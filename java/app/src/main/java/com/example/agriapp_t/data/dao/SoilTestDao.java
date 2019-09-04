package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agriapp_t.data.model.table.SoilTestTable;

@Dao
public interface SoilTestDao {

    @Insert
    void insert(SoilTestTable soilTestTable);

    @Query("SELECT * FROM soil_test_table " +
            "WHERE texture_class = :textureClass " +
            "AND nutrient = :nutrient " +
            "AND low <= :val " +
            "AND upper >= :val")
    SoilTestTable getTestInterpretationByInput(String textureClass, String nutrient, double val);
}
