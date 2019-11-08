package com.farida.sprint;

import java.util.Objects;

public class HomeTask {
    private String name;
    private String recommendation;


    public HomeTask(String name, String recommendation) {
        this.name = name;
        this.recommendation = recommendation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeTask homeTask = (HomeTask) o;
        return name.equals(homeTask.name) &&
                recommendation.equals(homeTask.recommendation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, recommendation);
    }
}

