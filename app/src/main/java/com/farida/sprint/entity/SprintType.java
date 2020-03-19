package com.farida.sprint.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;


@Entity (tableName = "types")
public class SprintType {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @SerializedName("name")
    private String sprintTypeName;

    public SprintType(String sprintTypeName) {
        this.sprintTypeName = sprintTypeName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setSprintTypeName(String sprintTypeName) {
        this.sprintTypeName = sprintTypeName;
    }

    public String getSprintTypeName() {
        return sprintTypeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof SprintType))
            return false;

        SprintType other = (SprintType) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, sprintTypeName);
    }
}
