package com.farida.sprint.module;

import com.farida.sprint.CreateSprintActivity;
import com.farida.sprint.sprintTask.SprintTasksActivity;
import com.farida.sprint.sprintType.SprintTypeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
interface ActivityModule {
    @ContributesAndroidInjector
    SprintTypeActivity contributeSprintTypeActivityInjector();

    @ContributesAndroidInjector
    SprintTasksActivity contributeSprintTasksActivityInjector();

    @ContributesAndroidInjector
    CreateSprintActivity contributeCreateSprintActivityInjector();
}
