package com.vasylpopovych.java.lab2.parsers;

import com.vasylpopovych.java.lab2.Gem;
import com.vasylpopovych.java.lab2.VisualParameters;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GemDOMParser {
    private static final Logger logger = Logger.getLogger(GemDOMParser.class.getName());
    public List<Gem> parse(String filePath) {
        List<Gem> gemList = new ArrayList<Gem>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("Gem");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    Gem gem = new Gem();
                    gem.setId(Integer.parseInt(element.getAttribute("id")));
                    gem.setName(getTagValue("Name", element));
                    gem.setPreciousness(element.getAttribute("preciousness"));
                    gem.setOrigin(getTagValue("Origin", element));
                    gem.setVisualParameters(getVisualParameters(element));
                    gem.setValue(Double.parseDouble(getTagValue("Value", element)));

                    gemList.add(gem);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred while adding a gem to the list", e);
        }

        return gemList;
    }

    private VisualParameters getVisualParameters(Element gemElement) {
        NodeList visualParamsList = gemElement.getElementsByTagName("VisualParameters");
        Element visualParamsElement = (Element) visualParamsList.item(0);
        String color = getTagValue("Color", visualParamsElement);
        int transparency = Integer.parseInt(getTagValue("Transparency", visualParamsElement));
        int cut = Integer.parseInt(getTagValue("Cut", visualParamsElement));

        return new VisualParameters(color, transparency, cut);
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        Node node = nodeList.item(0).getFirstChild();
        return node.getNodeValue();
    }
}
