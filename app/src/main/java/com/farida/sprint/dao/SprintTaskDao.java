package com.farida.sprint.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.farida.sprint.entity.SprintTask;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;


@Dao
public interface SprintTaskDao {
    /*@Query("SELECT * from sprints")
    List<SprintTask> getAll();
    @Query("SELECT * from sprints where sid = :id")
    SprintTask getById(long id);*/

    @Query("select * from sprintTask")
    Flowable<List<SprintTask>> getSprintTasks();

    @Query("select * from sprintTask limit 1")
    Single<SprintTask> getSprintTask();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SprintTask sprintTask);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SprintTask> sprintTasks);

    @Update
    void update(SprintTask sprintTask);

    @Delete
    void delete(SprintTask sprintTask);

    @Query("select count(*) from sprintTask")
    int getSprintTaskCount();

    @Query("select * from sprintTask where id = :id")
    LiveData<SprintTask> getSprintTaskById(long id);

    @Query("select * from sprintTask where sprint_type_id = :id")
    LiveData<List<SprintTask>> getSprintTasksForSprintType(long id);

    /*@Query("SELECT * from sprintTask ORDER BY sprint_type_name ASC")
    LiveData<List<SprintTask>> getAllSprintTasks();*/
}