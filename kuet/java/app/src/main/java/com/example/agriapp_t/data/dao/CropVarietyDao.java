package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agriapp_t.data.model.CropVariety;

import java.util.List;

@Dao
public interface CropVarietyDao {

    @Insert
    void insert (CropVariety cropVariety);

    @Query("SELECT class_unique FROM crop_variety " +
            "WHERE season = :season " +
            "AND variety = :variety ")
    int getUniqueClassBySeasonVariety(String season, String variety);
}
