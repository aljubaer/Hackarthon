package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agriapp_t.data.model.CropSeason;

import java.util.List;

@Dao
public interface CropSeasonDao {

    @Insert
    void insert (CropSeason cropSeason);

    @Query("SELECT season FROM crop_season " +
            "WHERE crop_group= :cropGroup ")
    List<String> getAllSeasonByCropGroup(String cropGroup);

    @Query("SELECT DISTINCT crop_group FROM crop_season")
    List<String> getAllDistinctCropGroup();

//    @Query("SELECT crop.crop_group FROM crop,crop_season " +
//            "WHERE crop_season.season = :season")
//    String getCropGroupBySeason(String season);
}
