package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agriapp_t.data.model.Nutrient;

import java.util.List;

@Dao
public interface NutrientDao {

    @Insert
    void insert(Nutrient nutrient);

    @Query("SELECT * FROM nutrient")
    List<Nutrient> getAllNutrients();
}
