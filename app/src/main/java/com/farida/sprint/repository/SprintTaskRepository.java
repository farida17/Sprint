package com.farida.sprint.repository;

import androidx.lifecycle.LiveData;

import com.farida.sprint.dao.SprintTaskDao;
import com.farida.sprint.entity.SprintTask;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public final class SprintTaskRepository {

    private final SprintTaskDao sprintTaskDao;

    @Inject
    SprintTaskRepository(SprintTaskDao sprintTaskDao) {
        this.sprintTaskDao = sprintTaskDao;
    }

    public Flowable<List<SprintTask>> getSprintTasks() {
        return sprintTaskDao.getSprintTasks();
    }

    /*public Single<SprintTask> getSprintTask() {
        return sprintTaskDao.getSprintTask();
    }*/

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
