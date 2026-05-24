package com.studi.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executors;

// Entity dan Versi Database
@Database(entities = {Siswa.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // DAO yang akan digunakan
    public abstract SiswaDAO siswaDAO();

    // Singleton: untuk mencegah banyak instans database
    // terbuka secara bersamaan
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "siswa_db")
                            .setQueryExecutor(Executors.newSingleThreadExecutor()) // Memisahkan thread query
                            .fallbackToDestructiveMigration(true)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
