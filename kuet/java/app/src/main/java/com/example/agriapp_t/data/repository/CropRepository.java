package com.example.agriapp_t.data.repository;

import android.app.Application;
import android.os.AsyncTask;


import com.example.agriapp_t.data.dao.CropDao;
import com.example.agriapp_t.data.database.Database;
import com.example.agriapp_t.data.model.Crop;

import java.util.List;
import java.util.concurrent.Executors;

public class CropRepository {
    Database database;
    public CropRepository (Application application) {
         database = Database.getInstance(application);
    }

    public void test () {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                List<String> allDistinctCropGroup = database.cropSeasonDao().getAllDistinctCropGroup();
                System.out.println(allDistinctCropGroup.size() + " -> " + allDistinctCropGroup.toString());
                List<Integer> allAnalysis = database.soilAnalysisDao().getAllAnalysis();
                System.out.println(allAnalysis.size());
            }
        });
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
