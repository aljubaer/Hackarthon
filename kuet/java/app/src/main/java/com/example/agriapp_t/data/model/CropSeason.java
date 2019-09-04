package com.example.agriapp_t.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "crop_season")
public class CropSeason {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "season")
    private String cropSeason;

    @ColumnInfo(name = "crop_group")
    private String cropGroup;

    @ColumnInfo(name = "crop_land_type")
    private String cropLandType;

    public CropSeason(String cropGroup, @NotNull String cropSeason, String cropLandType) {
        this.cropSeason = cropSeason;
        this.cropGroup = cropGroup;
        this.cropLandType = cropLandType;
    }

    @NotNull
    public String getCropSeason() {
        return cropSeason;
    }

    public String getCropGroup() {
        return cropGroup;
    }

    public String getCropLandType() {
        return cropLandType;
    }
}
