package com.vasylpopovych.java.lab2.parsers;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLValidator {
    private static final Logger logger = Logger.getLogger(XMLValidator.class.getName());
    public boolean validateXMLSchema(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred while validate the schema", e);
            return false;
        }
    }
}