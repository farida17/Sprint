package com.farida.sprint.sprintType;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farida.sprint.LifecycleDaggerActivity;
import com.farida.sprint.R;
import com.farida.sprint.entity.SprintType;
import com.farida.sprint.sprintTask.SprintTasksActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SprintTypeActivity extends LifecycleDaggerActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private SprintTypeViewModel sprintTypeViewModel;
    private SprintTypeAdapter sprintTypeAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprint_type);

        initViewModel();
        obtainData();
        initAdapter();
        initRecyclerView();

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

    }

        private void initViewModel() {
            sprintTypeViewModel = new ViewModelProvider(this, viewModelFactory).get(SprintTypeViewModel.class);
        }

        private void obtainData () {
            LiveData<List<SprintType>> listTypeLiveData = sprintTypeViewModel.getAllSprintTypes();
            listTypeLiveData.observe(this, sprintTypes -> sprintTypeAdapter.setSprintTypes(sprintTypes));
        }

        private void initAdapter () {
            SprintTypeAdapter.OnSprintTypeClickListener listener = this::onSprintTypeClick;
            sprintTypeAdapter = new SprintTypeAdapter(listener);
        }

        private void initRecyclerView () {
            RecyclerView recyclerView = findViewById(R.id.sprintTypes);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(sprintTypeAdapter);
        }

        public void onSprintTypeClick (SprintType sprintType){
            Intent toStartSprintTaskActivity = new Intent(this, SprintTasksActivity.class);
            toStartSprintTaskActivity.putExtra("id", sprintType.getId());
            startActivity(toStartSprintTaskActivity);
        }

    }
