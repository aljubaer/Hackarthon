package com.example.agriapp_t.data.model.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "texture")
public class SoilTextureTable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String texture;

    @ColumnInfo(name = "land_type")
    private String cropLandType;

    @ColumnInfo(name = "texture_class")
    private String textureClass;

    public SoilTextureTable(String texture, String cropLandType, String textureClass) {
        this.texture = texture;
        this.cropLandType = cropLandType;
        this.textureClass = textureClass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTexture() {
        return texture;
    }

    public String getCropLandType() {
        return cropLandType;
    }

    public String getTextureClass() {
        return textureClass;
    }
}
