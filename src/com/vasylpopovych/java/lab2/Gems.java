package com.vasylpopovych.java.lab2;

import java.util.Comparator;
import java.util.List;

public class Gems {
    private List<Gem> gemsList;

    public Gems(List<Gem> gemsList) {
        this.gemsList = gemsList;
    }

    public List<Gem> getGemsList() {
        return gemsList;
    }

    public void sortByValueAscending() {
        gemsList.sort(Comparator.comparingDouble(Gem::getValue));
    }

    public void sortByValueDescending() {
        gemsList.sort(Comparator.comparingDouble(Gem::getValue).reversed());
    }

    public void printAsJson() {
        System.out.println("{\n  \"Gems\": [");
        for (int i = 0; i < gemsList.size(); i++) {
            System.out.print(gemsList.get(i).toString());
            if (i < gemsList.size() - 1) {
                System.out.print(",\n");
            } else {
                System.out.print("\n");
            }
        }
        System.out.println("  ]\n}");
    }
}