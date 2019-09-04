package com.example.agriapp_t.data.repository;

import android.app.Application;
import android.os.AsyncTask;


import com.example.agriapp_t.data.dao.CropDao;
import com.example.agriapp_t.data.database.Database;
import com.example.agriapp_t.data.model.Crop;

import java.util.List;

public class CropRepository {

    public CropRepository (Application application) {
        Database database = Database.getInstance(application);
    }

//    public void insert (Crop crop) {
//        new InsertAsyncTask(cropDao).execute(crop);
//    }
//
//    public List<Crop> getAllCrop() {
//        return this.crops;
//    }
//
//    private static class InsertAsyncTask extends AsyncTask<Crop, Void, Void> {
//        private CropDao cropDao;
//
//        private InsertAsyncTask(CropDao cropDao) {
//            this.cropDao = cropDao;
//        }
//
//        @Override
//        protected Void doInBackground(Crop... crops) {
//            cropDao.insert(crops[0]);
//            return null;
//        }
//    }
}
