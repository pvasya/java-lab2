package com.vasylpopovych.java.lab2.test.parsers;

import com.vasylpopovych.java.lab2.Gem;
import com.vasylpopovych.java.lab2.Gems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComparatorTest {
    private Gems gems;
    private Gem gem1;
    private Gem gem2;
    private Gem gem3;
    private Gem gem4;
    private Gem gem5;

    @BeforeEach
    public void setUp() {
        gem1 = new Gem();
        gem1.setName("Ruby");
        gem1.setValue(500);

        gem2 = new Gem();
        gem2.setName("Emerald");
        gem2.setValue(300);

        gem3 = new Gem();
        gem3.setName("Sapphire");
        gem3.setValue(700);

        gem4 = new Gem();
        gem4.setName("Qwerty");
        gem4.setValue(1700);

        gem5 = new Gem();
        gem5.setName("RedSapphire");
        gem5.setValue(100);

        List<Gem> gemsList = new ArrayList<>(Arrays.asList(gem1, gem2, gem3, gem4, gem5));
        gems = new Gems(gemsList);
    }

    @Test
    public void testSortByValueAscending() {
        gems.sortByValueAscending();
        List<Gem> sortedAscending = gems.getGemsList();

        assertEquals(gem5, sortedAscending.get(0));
        assertEquals(gem2, sortedAscending.get(1));
        assertEquals(gem1, sortedAscending.get(2));
        assertEquals(gem3, sortedAscending.get(3));
        assertEquals(gem4, sortedAscending.get(4));
    }

    @Test
    public void testSortByValueDescending() {
        gems.sortByValueDescending();
        List<Gem> sortedDescending = gems.getGemsList();

        assertEquals(gem4, sortedDescending.get(0));
        assertEquals(gem3, sortedDescending.get(1));
        assertEquals(gem1, sortedDescending.get(2));
        assertEquals(gem2, sortedDescending.get(3));
        assertEquals(gem5, sortedDescending.get(4));
    }
}
