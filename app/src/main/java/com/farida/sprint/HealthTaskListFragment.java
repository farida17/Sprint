package com.farida.sprint;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;


public class HealthTaskListFragment extends Fragment implements SprintAdapter.Listener {

    private ListAdapter<SprintTask, SprintAdapter.ViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView healthRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_home_task, container, false);
        adapter = new SprintAdapter();
        adapter.submitList(healthLists);
        healthRecycler.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getActivity());
        healthRecycler.setLayoutManager(layoutManager);

        return healthRecycler;
        }

    public static List<SprintTask> healthLists = Arrays.asList(
            new SprintTask("Йога", "hjjhb", R.drawable.ndbfjhdfbv),
            new SprintTask("Неделя без сахара", "njbnbn", R.drawable.ndbfjhdfbv),
            new SprintTask("Неделя без животных продуктов", "jvbhjb", R.drawable.ndbfjhdfbv)
            );

    @Override
    public void onClick(int position) {

    }
}


