package com.vasylpopovych.java.lab2.parsers;

import com.vasylpopovych.java.lab2.Gem;
import com.vasylpopovych.java.lab2.VisualParameters;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GemSAXParser {
    private static final Logger logger = Logger.getLogger(GemSAXParser.class.getName());
    public List<Gem> parse(String filePath) {
        List<Gem> gemList = new ArrayList<Gem>();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                private Gem currentGem;
                private VisualParameters currentVisualParameters;
                private StringBuilder content;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("Gem")) {
                        currentGem = new Gem();
                        currentGem.setId(Integer.parseInt(attributes.getValue("id")));
                        currentGem.setPreciousness(attributes.getValue("preciousness"));
                    } else if (qName.equalsIgnoreCase("VisualParameters")) {
                        currentVisualParameters = new VisualParameters();
                    }
                    content = new StringBuilder();
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    content.append(ch, start, length);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    switch (qName.toLowerCase()) {
                        case "gem":
                            gemList.add(currentGem);
                            break;
                        case "name":
                            currentGem.setName(content.toString());
                            break;
                        case "origin":
                            currentGem.setOrigin(content.toString());
                            break;
                        case "value":
                            currentGem.setValue(Double.parseDouble(content.toString()));
                            break;
                        case "visualparameters":
                            currentGem.setVisualParameters(currentVisualParameters);
                            break;
                        case "color":
                            currentVisualParameters.setColor(content.toString());
                            break;
                        case "transparency":
                            currentVisualParameters.setTransparency(Integer.parseInt(content.toString()));
                            break;
                        case "cut":
                            currentVisualParameters.setCut(Integer.parseInt(content.toString()));
                            break;
                    }
                }
            };

            saxParser.parse(new File(filePath), handler);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred while adding a gem to the list", e);
        }

        return gemList;
    }
}
