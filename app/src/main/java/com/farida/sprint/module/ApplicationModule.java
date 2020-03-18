package com.farida.sprint.module;

import com.farida.sprint.SprintDatabase;
import com.farida.sprint.initializer.DatabaseInitializer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.support.AndroidSupportInjectionModule;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = {
        InitializerModule.class,
        ActivityModule.class,
        DatabaseModule.class,
        ViewModelModule.class,
        AndroidSupportInjectionModule.class})
class ApplicationModule {
    @Provides
    @Singleton
    SprintDatabase providesDatabase(DatabaseInitializer databaseInitializer) {
        return databaseInitializer.getDatabase();
    }

    @Provides
    @Singleton
    Executor providesExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    public CompositeDisposable getCompositeDisposable() {
        return new CompositeDisposable();
    }
}
