package com.vasylpopovych.java.lab2;

public class Gem {
    private int Id;
    private String name;
    private String preciousness;
    private String origin;
    private VisualParameters visualParameters;
    private double value;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"preciousness\": \"" + preciousness + "\",\n" +
                "  \"origin\": \"" + origin + "\",\n" +
                "  \"visualParameters\": " + visualParameters.toString() + ",\n" +
                "  \"value\": " + value + "\n" +
                "}";
    }

}