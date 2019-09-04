package com.example.agriapp_t.ui.land_list;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.agriapp_t.data.model.Land;
import com.example.agriapp_t.data.repository.LandRepository;

import java.util.List;

public class LandViewModel extends AndroidViewModel {

    private LandRepository repository;
    private LiveData<List<Land>> allLands;

    public LandViewModel(@NonNull Application application) {
        super(application);
        repository = new LandRepository(application);
        allLands = repository.getAllLands();
    }

    public void insert (Land land) {
        repository.insert(land);
    }

    public void update (Land land) {
        repository.update(land);
    }

    public void delete (Land land) {
        repository.delete(land);
    }

    public LiveData<List<Land>> getAllLands() {
        return allLands;
    }
}
