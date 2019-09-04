package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agriapp_t.data.model.Soil;
import com.example.agriapp_t.data.model.table.LandNutrientJoin;

@Dao
public interface SoilDao {

    @Insert
    void insert (Soil soil);

    @Delete
    void delete (Soil soil);

    @Query("SELECT * FROM soil " +
            "WHERE land_id = :landId ")
    Soil getSoil (int landId);

    @Insert
    void insertLandNutrientJoin (LandNutrientJoin landNutrientJoin);

    @Delete
    void deleteLandNutrientJoin (LandNutrientJoin landNutrientJoin);

    @Query("SELECT * FROM land_nutrient_join " +
            "WHERE land_id = :landId")
    LandNutrientJoin getLandNutrientData (int landId);
}
