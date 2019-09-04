package com.example.agriapp_t.data.model.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.agriapp_t.data.model.Nutrient;

@Entity(tableName = "soil_test_table",
        foreignKeys = {@ForeignKey(
                entity = SoilTextureTable.class,
                parentColumns = "texture_class",
                childColumns = "texture_class"
        ),
                @ForeignKey(
                        entity = Nutrient.class,
                        parentColumns = "symbol",
                        childColumns = "nutrient"
                )
        })
public class SoilTestTable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "texture_class")
    private String textureClass;

    @ColumnInfo(name = "nutrient")
    private String nutrient;

    @ColumnInfo(name = "status")
    private String testNutrientStatus;

    @ColumnInfo(name = "low")
    private double testNutrientLowerLimit;

    @ColumnInfo(name = "upper")
    private double testNutrientUpperLimit;

    @ColumnInfo(name = "interval")
    private double testNutrientInterval;

    public SoilTestTable(String textureClass,
                         String nutrient,
                         String testNutrientStatus,
                         double testNutrientLowerLimit,
                         double testNutrientUpperLimit,
                         double testNutrientInterval) {
        this.textureClass = textureClass;
        this.nutrient = nutrient;
        this.testNutrientStatus = testNutrientStatus;
        this.testNutrientLowerLimit = testNutrientLowerLimit;
        this.testNutrientUpperLimit = testNutrientUpperLimit;
        this.testNutrientInterval = testNutrientInterval;
    }

    public String getTextureClass() {
        return textureClass;
    }

    public String getNutrient() {
        return nutrient;
    }

    public String getTestNutrientStatus() {
        return testNutrientStatus;
    }

    public double getTestNutrientLowerLimit() {
        return testNutrientLowerLimit;
    }

    public double getTestNutrientUpperLimit() {
        return testNutrientUpperLimit;
    }

    public double getTestNutrientInterval() {
        return testNutrientInterval;
    }
}
