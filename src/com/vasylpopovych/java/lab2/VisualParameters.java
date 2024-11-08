package com.vasylpopovych.java.lab2;

public class VisualParameters {
    private String color;
    private int transparency;
    private int cut;

    public void setColor(String color) {
        this.color = color;
    }

    public VisualParameters() {
    }

    public VisualParameters(String color, int transparency, int cut) {
        this.color = color;
        this.transparency = transparency;
        this.cut = cut;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public void setCut(int cut) {
        this.cut = cut;
    }

    public String getColor() {
        return color;
    }

    public int getTransparency() {
        return transparency;
    }

    public int getCut() {
        return cut;
    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"color\": \"" + color + "\",\n" +
                "    \"transparency\": " + transparency + ",\n" +
                "    \"cut\": " + cut + "\n" +
                "  }";
    }

}
