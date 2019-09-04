package com.example.agriapp_t.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.agriapp_t.data.model.Crop;

import java.util.List;

@Dao
public interface CropDao {

    @Insert
    void insert(Crop crop);

    @Query("SELECT * FROM crop")
    List<Crop> getAllCrops();

}
