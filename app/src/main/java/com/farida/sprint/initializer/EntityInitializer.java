package com.farida.sprint.initializer;

import android.content.Context;

import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

abstract class EntityInitializer<T> implements Initializer {
    private Context context;

    EntityInitializer(Context context) {
        this.context = context;
    }

    @WorkerThread
    @Override
    public void initialize() {
        if(needToInitialize()) {
            BufferedReader bufferedReader = getReader();
            saveToDatabase(buildGson().fromJson(bufferedReader, getType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private BufferedReader getReader() {
        InputStream stream = context.getResources().openRawResource(getJsonResourceId());
        InputStreamReader streamReader = new InputStreamReader(stream);
        return new BufferedReader(streamReader);
    }

    Gson buildGson() {
        return new Gson();
    }

    abstract boolean needToInitialize();
    abstract Type getType();
    abstract @RawRes
    int getJsonResourceId();
    abstract void saveToDatabase(T data);
}
