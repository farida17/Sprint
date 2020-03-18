package com.farida.sprint;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class SprintTypeRepository {

    private SprintTypeDao sprintTypeDao;

    @Inject
    SprintTypeRepository(SprintTypeDao sprintTypeDao) {
        this.sprintTypeDao = sprintTypeDao;
    }

    public boolean isEmpty() {
        return sprintTypeDao.getSprintTypeCount() == 0;
    }

    LiveData<List<SprintType>> getSprintTypes() {
        return sprintTypeDao.getAllSprintTypes();
    }

    public void insert(List<SprintType> sprintTypes) {
            sprintTypeDao.insert(sprintTypes);
    }
}