package com.vasylpopovych.java.lab2.test.parsers;

import com.vasylpopovych.java.lab2.Gems;
import com.vasylpopovych.java.lab2.parsers.GemSAXParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemSAXParserTest {
    private GemSAXParser saxParser;
    private Gems gems;

    @BeforeEach
    void setUp() {
        saxParser = new GemSAXParser();
        gems = new Gems(saxParser.parse("res/diamond.xml"));
    }

    @Test
    void testParseSize() {
        assertEquals(3, gems.getGemsList().size());
    }

    @Test
    void testParseName() {
        assertEquals("Diamond", gems.getGemsList().getFirst().getName());
    }

    @Test
    void testParseValue() {
        assertEquals(1.5, gems.getGemsList().getFirst().getValue());
    }

    @Test
    void testParsePreciousness() {
        assertEquals("Precious", gems.getGemsList().getFirst().getPreciousness());
    }

    @Test
    void testParseName2() {
        assertEquals("Amethyst", gems.getGemsList().get(1).getName());
    }
}