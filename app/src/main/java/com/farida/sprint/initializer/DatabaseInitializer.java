package com.farida.sprint.initializer;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.farida.sprint.BuildConfig;
import com.farida.sprint.SprintDatabase;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class DatabaseInitializer implements Initializer {
    private static final String DATABASE_NAME = "Sprint.db";

    private SprintDatabase db;
    private Context context;

    @Inject
    DatabaseInitializer(Context context) {
        this.context = context;
    }


    public SprintDatabase getDatabase() {
        return db;
    }

    @Override
    public void initialize() {
        if (BuildConfig.DEBUG) {
            this.context.deleteDatabase(DATABASE_NAME);
        }

        RoomDatabase.Builder<SprintDatabase> dbBuilder = Room.databaseBuilder(this.context, SprintDatabase.class, DATABASE_NAME);
        db = dbBuilder.build();
    }
}
