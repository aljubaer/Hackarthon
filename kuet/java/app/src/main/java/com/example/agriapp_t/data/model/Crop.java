package com.example.agriapp_t.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

// crop.csv

@Entity(tableName = "crop")
public class Crop {

    @PrimaryKey
    @ColumnInfo(name = "crop_name")
    @NonNull
    private String cropName;

    // from crop_group.csv
    @ColumnInfo(name = "crop_group")
    private String cropGroup;

    @ColumnInfo(name = "crop_land_type")
    private String cropLandType;

    public Crop(@NonNull String cropName, String cropGroup, String cropLandType) {
        this.cropName = cropName;
        this.cropGroup = cropGroup;
        this.cropLandType = cropLandType;
    }

    @NonNull
    public String getCropName() {
        return cropName;
    }

    public String getCropGroup() {
        return cropGroup;
    }

    public String getCropLandType() {
        return cropLandType;
    }
}
