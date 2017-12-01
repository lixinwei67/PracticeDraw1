package com.hencoder.hencoderpracticedraw1;

/**
 * @author lixinwei
 */
public class Data {

    private String label;
    private String fullLabel;
    private float weight;
    private int color;

    public Data(String label, float weight, int color) {
        this.label = label;
        this.weight = weight;
        this.color = color;
    }

    public Data(String label, String fullLabel, float weight, int color) {
        this.label = label;
        this.fullLabel = fullLabel;
        this.weight = weight;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFullLabel() {
        return fullLabel;
    }

    public void setFullLabel(String fullLabel) {
        this.fullLabel = fullLabel;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
