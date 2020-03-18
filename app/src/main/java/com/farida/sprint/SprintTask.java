package com.farida.sprint;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "sprintTask",
        foreignKeys = @ForeignKey(entity = SprintType.class,
                parentColumns = "id",
                childColumns = "sprint_type_id"))

public class SprintTask {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String recommendation;
    private String startDate;
    private String finishDate;
    private String remindTime;
    private String remindDay;
    @ColumnInfo(name = "sprint_type_id", index = true)
    private long sprintType;

    /*public SprintTask(@NonNull String name, String recommendation) {
        this.name = name;
        this.recommendation = recommendation;
    }*/

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }
    public String getRemindTime() {
        return remindTime;
    }
    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }
    public String getRemindDay() {
        return remindDay;
    }
    public void setRemindDay(String remindDay) {
        this.remindDay = remindDay;
    }

    public long getSprintType() {
        return sprintType;
    }

    public void setSprintType(long sprintType) {
        this.sprintType = sprintType;
    }

    @NonNull
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
