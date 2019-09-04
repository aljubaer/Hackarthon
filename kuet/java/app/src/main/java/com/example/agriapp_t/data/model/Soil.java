package com.example.agriapp_t.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "soil")
public class Soil {

    @PrimaryKey
    @ColumnInfo(name = "land_id")
    private int landId;
    private double ph;

    public Soil(int landId, double ph) {
        this.landId = landId;
        this.ph = ph;
    }

    public int getLandId() {
        return landId;
    }

    public double getPh() {
        return ph;
    }
}
