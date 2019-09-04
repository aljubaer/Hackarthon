package com.example.agriapp_t.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "crop_season")
public class CropSeason {

    @PrimaryKey
    @ColumnInfo(name = "season")
    private String cropSeason;

    @ColumnInfo(name = "crop_name")
    private String cropName;

    @ColumnInfo(name = "crop_land_type")
    private String cropLandType;

    public CropSeason(String cropSeason, String cropName, String cropLandType) {
        this.cropSeason = cropSeason;
        this.cropName = cropName;
        this.cropLandType = cropLandType;
    }

    public String getCropSeason() {
        return cropSeason;
    }

    public String getCropName() {
        return cropName;
    }

    public String getCropLandType() {
        return cropLandType;
    }
}
