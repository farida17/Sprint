package com.farida.sprint.module;

import android.content.Context;

import com.farida.sprint.SprintApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(SprintApplication app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder injectContext(Context context);
        ApplicationComponent build();
    }
}
