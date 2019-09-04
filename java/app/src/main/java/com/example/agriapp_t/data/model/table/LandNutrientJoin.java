package com.example.agriapp_t.data.model.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.example.agriapp_t.data.model.Land;
import com.example.agriapp_t.data.model.Nutrient;

@Entity(tableName = "land_nutrient_join",
        primaryKeys = {"land_id", "nutrient"},
        foreignKeys = {
                @ForeignKey(entity = Land.class,
                            parentColumns = "id",
                            childColumns = "land_id"
                ),
                @ForeignKey(entity = Nutrient.class,
                        parentColumns = "symbol",
                        childColumns = "nutrient"
                )
        }
)
public class LandNutrientJoin {

    @ColumnInfo(name = "land_id")
    private int landId;

    @ColumnInfo(name = "nutrient")
    private String nutrient;

    @ColumnInfo(name = "input_value")
    private double inputValue;

    @ColumnInfo(name = "input_status")
    private String inputStatus;

    public LandNutrientJoin(int landId,
                            String nutrient,
                            double inputValue,
                            String inputStatus) {
        this.landId = landId;
        this.nutrient = nutrient;
        this.inputValue = inputValue;
        this.inputStatus = inputStatus;
    }

    public int getLandId() {
        return landId;
    }

    public String getNutrient() {
        return nutrient;
    }

    public double getInputValue() {
        return inputValue;
    }

    public String getInputStatus() {
        return inputStatus;
    }
}
