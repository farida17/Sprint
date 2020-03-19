package com.farida.sprint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.farida.sprint.entity.SprintTask;
import com.farida.sprint.repository.SprintTaskRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;


public class CreateSprintViewModel extends ViewModel {

    private LiveData<List<SprintTask>> sprintTask;

    private SprintTaskRepository sprintTaskRepository;

    @Inject
    public CreateSprintViewModel(SprintTaskRepository sprintTaskRepository) {
        this.sprintTaskRepository = sprintTaskRepository;
    }

    public Flowable<List<SprintTask>> getSprintTasks() {
        return sprintTaskRepository.getSprintTasks();
    }
    /*public Single<SprintTask> getSprintTask() {
        return sprintTaskRepository.getSprintTask();
    }*/

    public void insert(SprintTask sprintTask) {
        sprintTaskRepository.insert(sprintTask);
    }
}

