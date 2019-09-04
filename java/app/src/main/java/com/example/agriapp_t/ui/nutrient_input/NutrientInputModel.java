package com.example.agriapp_t.ui.nutrient_input;

public class NutrientInputModel {
    private String title;
    private double value;
    private String status;

    public NutrientInputModel(String title, double value, String status) {
        this.title = title;
        this.value = value;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public double getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }
}
