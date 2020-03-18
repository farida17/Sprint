package com.farida.sprint;

import androidx.lifecycle.LiveData;

public final class LiveDataUtil {
    private static final LiveData ABSENT = new LiveData() {
        {
            setValue(null);
        }
    };

    public static <T> LiveData<T> getAbsent() {
        // noinspection unchecked
        return (LiveData<T>) ABSENT;
    }
}
