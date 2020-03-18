package com.farida.sprint;

import android.app.Application;

import com.farida.sprint.initializer.AppInitializer;
import com.farida.sprint.module.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class SprintApplication extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Inject
    AppInitializer appInitializer;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder()
                .injectContext(getApplicationContext())
                .build()
                .inject(this);
        appInitializer.initialize();
    }
    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
