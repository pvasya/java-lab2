package com.vasylpopovych.java.lab2.test.parsers;

import com.vasylpopovych.java.lab2.parsers.XMLTransformer;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XMLTransformerTest {

    private XMLTransformer transformer = new XMLTransformer();

    private static final String INPUT_XML = "res/diamond.xml";
    private static final String XSL_FILE = "res/diamond.xsl";
    private static final String OUTPUT_XML = "res/outputdiamond.xml";

    @Test
    void testTransform() {
        transformer.transform(INPUT_XML, XSL_FILE, OUTPUT_XML);
        assertTrue(new File(OUTPUT_XML).exists());
    }
}