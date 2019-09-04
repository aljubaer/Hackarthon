package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agriapp_t.data.model.table.SoilAnalysisTable;

@Dao
public interface SoilAnalysisDao {

    @Insert
    void insert(SoilAnalysisTable soilAnalysisTable);

    @Query("SELECT * FROM soil_analysis_table " +
            "WHERE variety_class = :varietyClass " +
            "AND status = :soilStatus " +
            "AND nutrient = :nutrient")
    SoilAnalysisTable getAnalysisInterpretationByTestClass(String varietyClass,
                                                           String soilStatus,
                                                           String nutrient);
}
