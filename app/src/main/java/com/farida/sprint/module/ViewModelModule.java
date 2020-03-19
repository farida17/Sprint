package com.farida.sprint.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.farida.sprint.CreateSprintViewModel;
import com.farida.sprint.ViewModelFactory;
import com.farida.sprint.sprintTask.SprintTaskViewModel;
import com.farida.sprint.sprintType.SprintTypeViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SprintTypeViewModel.class)
    ViewModel bindsSprintTypeViewModel(SprintTypeViewModel sprintTypeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SprintTaskViewModel.class)
    ViewModel bindsSprintTaskViewModel(SprintTaskViewModel sprintTaskListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CreateSprintViewModel.class)
    ViewModel bindsCreateSprintViewModel(CreateSprintViewModel createSprintViewModel);

    @Binds
    ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}