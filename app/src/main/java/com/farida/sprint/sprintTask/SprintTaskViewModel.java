package com.farida.sprint.sprintTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.farida.sprint.entity.SprintTask;
import com.farida.sprint.repository.SprintTaskRepository;

import java.util.List;

import javax.inject.Inject;

public class SprintTaskViewModel extends ViewModel {

    private SprintTaskRepository sprintTaskRepository;

    private LiveData<List<SprintTask>> sprintTasks;

    @Inject
    SprintTaskViewModel(SprintTaskRepository sprintTaskRepository) {
        this.sprintTaskRepository = sprintTaskRepository;
    }

    LiveData<List<SprintTask>> getSprintTasksForCertainSprintType(long id) {
        if (sprintTasks == null) {
            sprintTasks = sprintTaskRepository.getSprintTasksForCertainSprintType(id);
        }
        return sprintTasks;
    }
}
