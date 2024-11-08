package com.vasylpopovych.java.lab2;

import com.vasylpopovych.java.lab2.parsers.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        String XMLFilePath = "res/diamond.xml";
        String XSDFilePath = "res/diamond.xsd";
        String XSLTFilePath = "res/diamond.xsl";
        String transformed = "res/outputdiamond.xml";

        GemDOMParser domParser = new GemDOMParser();
        GemSAXParser saxParser = new GemSAXParser();
        GemStAXParser staxParser = new GemStAXParser();

        Gems gemsDOM = new Gems(domParser.parse(XMLFilePath));
        Gems gemsSAX = new Gems(saxParser.parse(XMLFilePath));
        Gems gemsStAX = new Gems(staxParser.parse(XMLFilePath));

        LOGGER.log(Level.INFO, "Gems parsed by DOM:");
        gemsDOM.printAsJson();

        LOGGER.log(Level.INFO, "Gems parsed by SAX:");
        gemsSAX.printAsJson();

        LOGGER.log(Level.INFO, "Gems parsed by StAX:");
        gemsStAX.printAsJson();

        LOGGER.log(Level.INFO, "Sort by value:");
        gemsDOM.sortByValueAscending();
        gemsDOM.printAsJson();

        LOGGER.log(Level.INFO, "Reverse sort by value:");
        gemsSAX.sortByValueDescending();
        gemsSAX.printAsJson();


        LOGGER.log(Level.INFO, "Transform by value: color");
        XMLTransformer transformer = new XMLTransformer();
        transformer.transform(XMLFilePath, XSLTFilePath, transformed);

        XMLValidator validator = new XMLValidator();
        LOGGER.log(Level.INFO, "\nValidation result for XML file: {0}", validator.validateXMLSchema(XMLFilePath, XSDFilePath));
    }
}