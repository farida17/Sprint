package com.farida.sprint;

import java.util.Objects;

public class SprintTask {
    private String name;
    private String recommendation;

    public SprintTask(String name, String recommendation) {
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
        SprintTask sprintTask = (SprintTask) o;
        return name.equals(sprintTask.name) &&
                recommendation.equals(sprintTask.recommendation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, recommendation);
    }

}
