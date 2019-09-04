package com.example.agriapp_t.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.agriapp_t.data.dao.NutrientDao;
import com.example.agriapp_t.data.database.NoteDatabase;
import com.example.agriapp_t.data.model.Nutrient;

import java.util.List;

public class NutrientRepository {

    private NutrientDao nutrientDao;
    private List<Nutrient> allNutrient;

    public NutrientRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        nutrientDao = database.nutrientDao();
        allNutrient = nutrientDao.getAllNutrients();
    }

    public void insert (Nutrient nutrient) {
        new InsertNutrientAsyncTask(nutrientDao).execute(nutrient);
    }

    private static class InsertNutrientAsyncTask extends AsyncTask<Nutrient, Void, Void> {
        private NutrientDao nutrientDao;

        private InsertNutrientAsyncTask (NutrientDao nutrientDao) {
            this.nutrientDao = nutrientDao;
        }

        @Override
        protected Void doInBackground(Nutrient... nutrients) {
            nutrientDao.insert(nutrients[0]);
            return null;
        }
    }
}
