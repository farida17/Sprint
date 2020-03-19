package com.farida.sprint.sprintTask;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farida.sprint.CreateSprintActivity;
import com.farida.sprint.LifecycleDaggerActivity;
import com.farida.sprint.R;
import com.farida.sprint.entity.SprintTask;

import java.util.List;

import javax.inject.Inject;

public class SprintTasksActivity extends LifecycleDaggerActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private SprintTaskViewModel sprintTaskViewModel;
    private LiveData<List<SprintTask>> listTaskLiveData;
    private SprintTaskAdapter sprintTaskAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprint_tasks);
        initViewModel();
        obtainData();
        initAdapter();
        initRecyclerView();
    }

    private void initViewModel() {
        sprintTaskViewModel = new ViewModelProvider(this, viewModelFactory).get(SprintTaskViewModel.class);
    }

    private void obtainData() {
        Bundle args = getIntent().getExtras();
        long sprintTypeId = args.getLong("id");
        listTaskLiveData = sprintTaskViewModel.getSprintTasksForCertainSprintType(sprintTypeId);
    }

    private void initAdapter() {
        SprintTaskAdapter.OnSprintTaskClickListener listener = this::onSprintTaskClick;
        sprintTaskAdapter = new SprintTaskAdapter(listener);
        listTaskLiveData.observe(this, sprintTasks -> sprintTaskAdapter.setSprintTasks(sprintTasks));
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.sprintTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sprintTaskAdapter);
    }

    public void onSprintTaskClick(SprintTask sprintTask) {
        Intent startSprint = new Intent(this, CreateSprintActivity.class);
        startSprint.putExtra("id", sprintTask.getId());
        startActivity(startSprint);
    }
}
