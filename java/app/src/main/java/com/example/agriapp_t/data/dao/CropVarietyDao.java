package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface CropVarietyDao {

    @Query("SELECT class_unique FROM crop_variety " +
            "WHERE season = :season " +
            "AND variety = :variety ")
    String getUniqueClassBySeasonVariety(String season, String variety);
}
