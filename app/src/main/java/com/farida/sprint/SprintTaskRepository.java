package com.farida.sprint;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Singleton
public final class SprintTaskRepository {
    private final SprintTaskDao sprintTaskDao;
    private Executor executor;

    @Inject
    SprintTaskRepository(SprintTaskDao sprintTaskDao) {
        this.sprintTaskDao = sprintTaskDao;
    }

    public Flowable<List<SprintTask>> getSprintTasks() {
        return sprintTaskDao.getSprintTasks();
    }

    public Single<SprintTask> getSprintTask() {
        return sprintTaskDao.getSprintTask();
    }

    public LiveData<List<SprintTask>> getSprintTasksForCertainSprintType(long id) {
        return sprintTaskDao.getSprintTasksForSprintType(id);
    }

    public boolean isEmpty() {
        return sprintTaskDao.getSprintTaskCount() == 0;
    }

    public LiveData<SprintTask> getSprintTaskById(long id) {
        return sprintTaskDao.getSprintTaskById(id);
    }

    public void insertAll(List<SprintTask> sprintTasks) {
        sprintTaskDao.insertAll(sprintTasks);
    }

    public void insert(SprintTask sprintTask) {
        sprintTaskDao.insert(sprintTask);
    }
}
