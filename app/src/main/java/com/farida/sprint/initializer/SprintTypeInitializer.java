package com.farida.sprint.initializer;

import android.content.Context;

import com.farida.sprint.R;
import com.farida.sprint.SprintType;
import com.farida.sprint.SprintTypeRepository;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

public class SprintTypeInitializer extends EntityInitializer<List<SprintType>> {
    private Lazy<SprintTypeRepository> sprintTypeRepository;

    @Inject
    SprintTypeInitializer(Context context, Lazy<SprintTypeRepository> sprintTypeRepository) {
        super(context);
        this.sprintTypeRepository = sprintTypeRepository;
    }

    @Override
    boolean needToInitialize() {
        return sprintTypeRepository.get().isEmpty();
    }

    @Override
    Type getType() {
        return new TypeToken<List<SprintType>>(){}.getType();
    }

    @Override
    int getJsonResourceId() {
        return R.raw.sprint_types;
    }

    @Override
    void saveToDatabase(List<SprintType> sprintTypes) {
        sprintTypeRepository.get().insert(sprintTypes);
    }
}
