package com.example.agriapp_t.data.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.agriapp_t.data.dao.CropSeasonDao;
import com.example.agriapp_t.data.dao.CropVarietyDao;
import com.example.agriapp_t.data.dao.SoilAnalysisDao;
import com.example.agriapp_t.data.dao.SoilTestDao;
import com.example.agriapp_t.data.dao.SoilTextureDao;
import com.example.agriapp_t.data.model.Crop;
import com.example.agriapp_t.data.model.CropSeason;
import com.example.agriapp_t.data.model.CropVariety;
import com.example.agriapp_t.data.model.Nutrient;
import com.example.agriapp_t.data.model.table.SoilAnalysisTable;
import com.example.agriapp_t.data.model.table.SoilTestTable;
import com.example.agriapp_t.data.model.table.SoilTextureTable;
import com.example.agriapp_t.utils.CsvFileReader;

import java.util.List;

@androidx.room.Database(entities = {
                        Crop.class,
                        Nutrient.class,
                        CropSeason.class,
                        CropVariety.class,
                        SoilAnalysisTable.class,
                        SoilTestTable.class,
                        SoilTextureTable.class,
        }, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract CropSeasonDao cropSeasonDao();
    public abstract CropVarietyDao cropVarietyDao();
    public abstract SoilAnalysisDao soilAnalysisDao();
    public abstract SoilTestDao soilTestDao();
    public abstract SoilTextureDao soilTextureDao();

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "database_alpha_5")
                    .addCallback(roomCallback)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        new PopulateDbAsyncTask(instance).execute();
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CropSeasonDao cropSeasonDao;
        private CropVarietyDao cropVarietyDao;
        private SoilAnalysisDao soilAnalysisDao;
        private SoilTestDao soilTestDao;
        private SoilTextureDao soilTextureDao;

        private PopulateDbAsyncTask(Database db) {
            cropSeasonDao = db.cropSeasonDao();
            cropVarietyDao = db.cropVarietyDao();
            soilAnalysisDao = db.soilAnalysisDao();
            soilTestDao = db.soilTestDao();
            soilTextureDao = db.soilTextureDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<String[]> parsedData = new CsvFileReader().read("crop_class.csv");
            System.out.println(parsedData.size());
            return null;
        }
    }
}
