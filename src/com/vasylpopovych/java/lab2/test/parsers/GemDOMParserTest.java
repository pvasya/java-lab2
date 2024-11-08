package com.vasylpopovych.java.lab2.test.parsers;

import com.vasylpopovych.java.lab2.Gems;
import com.vasylpopovych.java.lab2.parsers.GemDOMParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemDOMParserTest {
    private GemDOMParser domParser;
    private Gems gems;

    @BeforeEach
    void setUp() {
        domParser = new GemDOMParser();
        gems = new Gems(domParser.parse("res/diamond.xml"));
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
