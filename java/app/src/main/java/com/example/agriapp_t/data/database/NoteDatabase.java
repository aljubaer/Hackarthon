package com.example.agriapp_t.data.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.agriapp_t.Note;
import com.example.agriapp_t.NoteDao;
import com.example.agriapp_t.data.dao.LandDao;
import com.example.agriapp_t.data.dao.NutrientDao;
import com.example.agriapp_t.data.model.Land;
import com.example.agriapp_t.data.model.Nutrient;

@Database(entities = {Note.class, Land.class, Nutrient.class}, version = 2)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();
    public abstract LandDao landDao();
    public abstract NutrientDao nutrientDao();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE nutrient " +
                            "(symbol TEXT NOT NULL, " +
                            "input_title TEXT, " +
                            "full_name TEXT, " +
                            "PRIMARY KEY(symbol))"
            );
        }
    };

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "test_database_alpha_2")
                    .addCallback(roomCallback)
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return instance;
    }

    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;
        private LandDao landDao;
        private NutrientDao nutrientDao;

        private PopulateDbAsyncTask(NoteDatabase db) {
            noteDao = db.noteDao();
            landDao = db.landDao();
            nutrientDao = db.nutrientDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Title 1", "Description 1", 1));
            noteDao.insert(new Note("Title 2", "Description 2", 2));
            noteDao.insert(new Note("Title 3", "Description 3", 3));

            landDao.insert(new Land("Land 1", "Highland", 5.0));
            landDao.insert(new Land("Land 2", "Highland", 5.0));
            return null;
        }
    }
}
