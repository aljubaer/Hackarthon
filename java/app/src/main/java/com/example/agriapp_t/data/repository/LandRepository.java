package com.example.agriapp_t.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.example.agriapp_t.data.dao.LandDao;
import com.example.agriapp_t.data.database.NoteDatabase;
import com.example.agriapp_t.data.model.Land;

import java.util.List;

public class LandRepository {

    private LandDao landDao;

    private LiveData<List<Land>> allLands;

    public LandRepository (Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        landDao = database.landDao();
        allLands = landDao.getAllLands();
    }

    public void insert (Land land) {
        new InsertLandAsyncTask(landDao).execute(land);
    }

    public void update (Land land) {
        new UpdateLandAsyncTask(landDao).execute(land);
    }

    public void delete (Land land) {
        new DeleteLandAsyncTask(landDao).execute(land);
    }

    public LiveData<List<Land>> getAllLands() {
        return this.allLands;
    }

    private static class InsertLandAsyncTask extends AsyncTask<Land, Void, Void> {
        private LandDao landDao;

        private InsertLandAsyncTask (LandDao landDao) {
            this.landDao = landDao;
        }

        @Override
        protected Void doInBackground(Land... lands) {
            landDao.insert(lands[0]);
            return null;
        }
    }

    private static class UpdateLandAsyncTask extends AsyncTask<Land, Void, Void> {
        private LandDao landDao;

        private UpdateLandAsyncTask (LandDao landDao) {
            this.landDao = landDao;
        }

        @Override
        protected Void doInBackground(Land... lands) {
            landDao.update(lands[0]);
            return null;
        }
    }

    private static class DeleteLandAsyncTask extends AsyncTask<Land, Void, Void> {
        private LandDao landDao;

        private DeleteLandAsyncTask (LandDao landDao) {
            this.landDao = landDao;
        }

        @Override
        protected Void doInBackground(Land... lands) {
            landDao.delete(lands[0]);
            return null;
        }
    }
}
