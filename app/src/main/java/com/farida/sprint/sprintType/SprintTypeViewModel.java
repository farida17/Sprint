package com.farida.sprint.sprintType;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.farida.sprint.LiveDataUtil;
import com.farida.sprint.entity.SprintType;
import com.farida.sprint.initializer.AppInitializer;
import com.farida.sprint.repository.SprintTypeRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

public class SprintTypeViewModel extends ViewModel {
    @Inject Lazy<SprintTypeRepository> sprintTypeRepository;
    private LiveData<List<SprintType>> listLiveDataType;

    @Inject
    SprintTypeViewModel(AppInitializer appInitializer) {
        listLiveDataType = Transformations.switchMap(
                appInitializer.getInitialized(),
            (initialized) -> initialized
                ? sprintTypeRepository.get().getSprintTypes()
                    : LiveDataUtil.getAbsent()
        );
    }

    LiveData<List<SprintType>> getAllSprintTypes() {
        return listLiveDataType;
    }
}
