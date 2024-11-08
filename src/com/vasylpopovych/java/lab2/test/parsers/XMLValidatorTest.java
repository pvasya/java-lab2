package com.vasylpopovych.java.lab2.test.parsers;


import com.vasylpopovych.java.lab2.parsers.XMLValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XMLValidatorTest {

    private static final String XMLFilePath = "res/diamond.xml";
    private static final String XSDFilePath = "res/diamond.xsd";

    @Test
    void validateXMLSchema() {
        XMLValidator validator = new XMLValidator();
        assertTrue(validator.validateXMLSchema(XMLFilePath, XSDFilePath));
    }

    @Test
    void validateXMLSchemaFail() {
        XMLValidator validator = new XMLValidator();
        assertFalse(validator.validateXMLSchema("res/diamond.xml", "res/outputdiamond.xml"));
    }
}