package com.farida.sprint.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.farida.sprint.SprintTaskViewModel;
import com.farida.sprint.SprintTypeViewModel;
import com.farida.sprint.ViewModelFactory;

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
    ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}