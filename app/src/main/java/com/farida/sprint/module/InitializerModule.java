package com.farida.sprint.module;

import com.farida.sprint.initializer.DatabaseInitializer;
import com.farida.sprint.initializer.Initializer;
import com.farida.sprint.initializer.SprintTaskInitializer;
import com.farida.sprint.initializer.SprintTypeInitializer;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

@Module
interface InitializerModule {
    @Binds
    @IntoMap
    @IntKey(0)
    Initializer bindsDatabaseInitializer(DatabaseInitializer dataBaseInitializer);

    @Binds
    @IntoMap
    @IntKey(1)
    Initializer bindsSprintTypeInitializer(SprintTypeInitializer muscleGroupInitializer);

    @Binds
    @IntoMap
    @IntKey(2)
    Initializer bindsSprintTaskInitializer(SprintTaskInitializer exerciseInitializer);
}
