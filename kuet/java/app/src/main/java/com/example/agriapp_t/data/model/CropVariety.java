package com.example.agriapp_t.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "crop_variety")


public class CropVariety {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "variety")
    private String cropVariety;

    @ColumnInfo(name = "season")
    private String cropSeason;

    @ColumnInfo(name = "class")
    private int seasonVarietyClass;

    @ColumnInfo(name = "class_unique")
    private int uniqueSeasonVarietyClass;

    public CropVariety(String cropSeason,
                       @NotNull String cropVariety,
                       int seasonVarietyClass,
                       int uniqueSeasonVarietyClass) {
        this.cropVariety = cropVariety;
        this.cropSeason = cropSeason;
        this.seasonVarietyClass = seasonVarietyClass;
        this.uniqueSeasonVarietyClass = uniqueSeasonVarietyClass;
    }

    @NotNull
    public String getCropVariety() {
        return cropVariety;
    }

    public String getCropSeason() {
        return cropSeason;
    }

    public int getSeasonVarietyClass() {
        return seasonVarietyClass;
    }

    public int getUniqueSeasonVarietyClass() {
        return uniqueSeasonVarietyClass;
    }
}
