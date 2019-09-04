package com.example.agriapp_t.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "crop_variety",
        foreignKeys = @ForeignKey(
                entity = CropSeason.class,
                parentColumns = "season",
                childColumns = "season"
        )
)
public class CropVariety {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "variety")
    private String cropVariety;

    @ColumnInfo(name = "season")
    private String cropSeason;

    @ColumnInfo(name = "class")
    private int seasonVarietyClass;

    @ColumnInfo(name = "class_unique")
    private int uniqueSeasonVarietyClass;

    public CropVariety(int id,
                       String cropVariety,
                       String cropSeason,
                       int seasonVarietyClass,
                       int uniqueSeasonVarietyClass) {
        this.id = id;
        this.cropVariety = cropVariety;
        this.cropSeason = cropSeason;
        this.seasonVarietyClass = seasonVarietyClass;
        this.uniqueSeasonVarietyClass = uniqueSeasonVarietyClass;
    }

    public int getId() {
        return this.id;
    }

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
