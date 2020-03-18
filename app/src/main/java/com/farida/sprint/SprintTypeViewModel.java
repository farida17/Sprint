package com.farida.sprint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.farida.sprint.initializer.AppInitializer;

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
