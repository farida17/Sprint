package com.farida.sprint;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SprintTypeDao {

    @Query("SELECT * from types")
    List<SprintType> getAll();

    @Query("SELECT * from types where id = :id")
    SprintType getById(long id);

    @Insert
    void insert(List <SprintType> sprintTypes);

    @Insert
    void insertAll(List<SprintType> sprintTypes);

    @Query("select count(*) from types")
    int getSprintTypeCount();

    @Update
    void update(SprintType sprintType);

    @Delete
    void delete(SprintType sprintType);

    @Query("DELETE FROM types")
    void deleteAll();

    @Query("SELECT * from types ORDER BY sprintTypeName ASC")
    LiveData<List<SprintType>> getAllSprintTypes();
}
