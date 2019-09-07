package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agriapp_t.data.model.table.SoilTextureTable;

import java.util.List;

@Dao
public interface SoilTextureDao {
//
//    @Query("SELECT DISTINCT texture FROM SoilTextureTable")
//    public List<String> getAllDistTexture();
//
//    @Query("SELECT texture_class FROM SoilTextureTable " +
//            "WHERE texture = :texture AND land_type = :cropLandType")
//    public String getTextureClassByTexture(String texture, String cropLandType);

    @Query("SELECT texture FROM texture")
    List<String> getAllTexture ();

    @Insert
    void insert (SoilTextureTable soilTextureTable);
}
