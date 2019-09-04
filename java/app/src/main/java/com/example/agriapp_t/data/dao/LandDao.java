package com.example.agriapp_t.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agriapp_t.data.model.Land;

import java.util.List;

@Dao
public interface LandDao {

    @Insert
    void insert(Land land);

    @Update
    void update(Land land);

    @Delete
    void delete(Land land);

    @Query("SELECT * FROM land")
    LiveData<List<Land>> getAllLands();
}
