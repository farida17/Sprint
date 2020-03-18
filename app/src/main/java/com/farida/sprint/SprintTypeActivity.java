package com.farida.sprint;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    //@BindView(R.id.daysOfMonth)
    //ChipGroup daysOfMonth;

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

        /*for (int i = 0; i < daysOfMonth.getChildCount(); i++) {
            Chip childAt = (Chip) daysOfMonth.getChildAt(i);
            childAt.setOnCheckedChangeListener((buttonView, isChecked) -> {
                System.out.println(getSelectedDaysOfWeek());
            });
        }*/

        /*
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new TopFragment())
                .commit();*/
    }

    /*private List<Integer> getSelectedDaysOfWeek() {
        List<Integer> result = new ArrayList<>(daysOfMonth.getChildCount());
        for (int i = 0; i < daysOfMonth.getChildCount(); i++) {
            Chip childAt = (Chip) daysOfMonth.getChildAt(i);
            if (childAt.isChecked()) {
                result.add(i);
            }
        }
        return result;
    }*/

    private void initViewModel() {
        sprintTypeViewModel = new ViewModelProvider(this, viewModelFactory).get(SprintTypeViewModel.class);
    }

    private void obtainData() {
        LiveData<List<SprintType>> listTypeLiveData = sprintTypeViewModel.getAllSprintTypes();
        listTypeLiveData.observe(this, sprintTypes -> sprintTypeAdapter.setSprintTypes(sprintTypes));
    }

    private void initAdapter() {
        SprintTypeAdapter.OnSprintTypeClickListener listener = this::onSprintTypeClick;
        sprintTypeAdapter = new SprintTypeAdapter(listener);
    }

    private void initRecyclerView() {
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
