package com.vasylpopovych.java.lab2.parsers;

import com.vasylpopovych.java.lab2.Gem;
import com.vasylpopovych.java.lab2.VisualParameters;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GemStAXParser {
    private static final Logger logger = Logger.getLogger(GemStAXParser.class.getName());
    public List<Gem> parse(String filePath) {
        List<Gem> gemList = new ArrayList<>();
        Gem gem = null;
        VisualParameters visualParameters = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();

        try (InputStream inputStream = new FileInputStream(filePath)) {
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String elementName = reader.getLocalName();

                        switch (elementName) {
                            case "Gem":
                                gem = new Gem();
                                gem.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
                                gem.setPreciousness(reader.getAttributeValue(null, "preciousness"));
                                break;
                            case "Name":
                                if (gem != null) {
                                    gem.setName(reader.getElementText());
                                }
                                break;
                            case "Origin":
                                if (gem != null) {
                                    gem.setOrigin(reader.getElementText());
                                }
                                break;
                            case "VisualParameters":
                                visualParameters = new VisualParameters();
                                break;
                            case "Color":
                                if (visualParameters != null) {
                                    visualParameters.setColor(reader.getElementText());
                                }
                                break;
                            case "Transparency":
                                if (visualParameters != null) {
                                    visualParameters.setTransparency(Integer.parseInt(reader.getElementText()));
                                }
                                break;
                            case "Cut":
                                if (visualParameters != null) {
                                    visualParameters.setCut(Integer.parseInt(reader.getElementText()));
                                }
                                break;
                            case "Value":
                                if (gem != null) {
                                    gem.setValue(Double.parseDouble(reader.getElementText()));
                                }
                                break;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        String endElementName = reader.getLocalName();
                        if ("Gem".equals(endElementName) && gem != null) {
                            gem.setVisualParameters(visualParameters);
                            gemList.add(gem);
                            gem = null;
                            visualParameters = null;
                        }
                        break;
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred while adding a gem to the list", e);
        }
        return gemList;
    }
}
