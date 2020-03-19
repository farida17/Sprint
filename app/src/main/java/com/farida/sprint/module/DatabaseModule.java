package com.farida.sprint.module;


import com.farida.sprint.SprintDatabase;
import com.farida.sprint.dao.SprintTaskDao;
import com.farida.sprint.dao.SprintTypeDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class DatabaseModule {
    @Provides
    @Singleton
    SprintTypeDao providesSprintTypeDao(SprintDatabase db) {
        return db.sprintTypeDao();
    }

    @Provides
    @Singleton
    SprintTaskDao providesSprintTaskDao(SprintDatabase db) {
        return db.sprintTaskDao();
    }
}
