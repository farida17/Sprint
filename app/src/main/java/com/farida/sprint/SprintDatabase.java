package com.farida.sprint;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.farida.sprint.dao.SprintTaskDao;
import com.farida.sprint.dao.SprintTypeDao;
import com.farida.sprint.entity.SprintTask;
import com.farida.sprint.entity.SprintType;

@Database(entities = {SprintTask.class, SprintType.class},
        version = 1,
        exportSchema = false)
public abstract class SprintDatabase extends RoomDatabase {

    public abstract SprintTaskDao sprintTaskDao();
    public abstract SprintTypeDao sprintTypeDao();
}
