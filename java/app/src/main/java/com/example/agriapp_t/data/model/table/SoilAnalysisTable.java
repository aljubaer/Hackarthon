package com.example.agriapp_t.data.model.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.agriapp_t.data.model.CropVariety;
import com.example.agriapp_t.data.model.Nutrient;

@Entity(tableName = "soil_analysis_table",
        foreignKeys = {@ForeignKey(
                            entity = CropVariety.class,
                            parentColumns = "class_unique",
                            childColumns = "variety_class"
                    ),
                    @ForeignKey(
                            entity = Nutrient.class,
                            parentColumns = "symbol",
                            childColumns = "nutrient"
                    )
        })
public class SoilAnalysisTable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "variety_class")
    private String varietyClass;

    @ColumnInfo(name = "nutrient")
    private String nutrient;

    @ColumnInfo(name = "status")
    private String analysisNutrientStatus;

    @ColumnInfo(name = "low")
    private double analysisNutrientLowerLimit;

    @ColumnInfo(name = "upper")
    private double analysisNutrientUpperLimit;

    @ColumnInfo(name = "interval")
    private double analysisNutrientInterval;

    public SoilAnalysisTable(String varietyClass,
                             String nutrient,
                             String analysisNutrientStatus,
                             double analysisNutrientLowerLimit,
                             double analysisNutrientUpperLimit,
                             double analysisNutrientInterval) {
        this.varietyClass = varietyClass;
        this.nutrient = nutrient;
        this.analysisNutrientStatus = analysisNutrientStatus;
        this.analysisNutrientLowerLimit = analysisNutrientLowerLimit;
        this.analysisNutrientUpperLimit = analysisNutrientUpperLimit;
        this.analysisNutrientInterval = analysisNutrientInterval;
    }

    public int getId() {
        return id;
    }

    public String getVarietyClass() {
        return varietyClass;
    }

    public String getNutrient() {
        return nutrient;
    }

    public String getAnalysisNutrientStatus() {
        return analysisNutrientStatus;
    }

    public double getAnalysisNutrientLowerLimit() {
        return analysisNutrientLowerLimit;
    }

    public double getAnalysisNutrientUpperLimit() {
        return analysisNutrientUpperLimit;
    }

    public double getAnalysisNutrientInterval() {
        return analysisNutrientInterval;
    }
}
