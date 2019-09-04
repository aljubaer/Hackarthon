package com.example.agriapp_t.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "land")
public class Land {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "land_type")
    private String landType;

    @ColumnInfo(name = "land_area")
    private double landArea;

    public Land(String title, String landType, double landArea) {
        this.title = title;
        this.landType = landType;
        this.landArea = landArea;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLandType() {
        return landType;
    }

    public double getLandArea() {
        return landArea;
    }
}
