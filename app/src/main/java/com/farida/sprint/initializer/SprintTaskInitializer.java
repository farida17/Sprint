package com.farida.sprint.initializer;

import android.content.Context;

import com.farida.sprint.R;
import com.farida.sprint.SprintTask;
import com.farida.sprint.SprintTaskRepository;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

public class SprintTaskInitializer extends EntityInitializer<List<SprintTask>> {
    private Lazy<SprintTaskRepository> sprintTaskRepository;

    @Inject
    SprintTaskInitializer(Context context, Lazy<SprintTaskRepository> sprintTaskRepository) {
        super(context);
        this.sprintTaskRepository = sprintTaskRepository;
    }

    @Override
    Type getType() {
        return new TypeToken<List<SprintTask>>(){}.getType();
    }

    @Override
    int getJsonResourceId() {
        return R.raw.sprint_tasks;
    }

    @Override
    boolean needToInitialize() {
        return sprintTaskRepository.get().isEmpty();
    }

    @Override
    void saveToDatabase(List<SprintTask> sprintTasks) {
        sprintTaskRepository.get().insertAll(sprintTasks);
    }
}