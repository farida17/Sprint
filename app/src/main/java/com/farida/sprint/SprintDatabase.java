package com.farida.sprint;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SprintTask.class, SprintType.class},
        version = 1,
        exportSchema = false)
public abstract class SprintDatabase extends RoomDatabase {

    public abstract SprintTaskDao sprintTaskDao();
    public abstract SprintTypeDao sprintTypeDao();

    /*static volatile SprintDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static SprintDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (SprintDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SprintDatabase.class, "sprints_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /*private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            }
    };*/
}
