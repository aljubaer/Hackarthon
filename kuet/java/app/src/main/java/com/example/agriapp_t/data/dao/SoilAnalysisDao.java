package com.example.agriapp_t.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agriapp_t.data.model.table.SoilAnalysisTable;

import java.util.List;

@Dao
public interface SoilAnalysisDao {

    @Insert
    void insert(SoilAnalysisTable soilAnalysisTable);

    @Query("SELECT id FROM soil_analysis_table")
    List<Integer> getAllAnalysis();

    @Query("SELECT * FROM soil_analysis_table " +
            "WHERE unique_id = :uniqueId " +
            "AND status = :soilStatus " +
            "AND nutrient = :nutrient")
    SoilAnalysisTable getAnalysisInterpretationByTestClass(int uniqueId,
                                                           String soilStatus,
                                                           String nutrient);
}
