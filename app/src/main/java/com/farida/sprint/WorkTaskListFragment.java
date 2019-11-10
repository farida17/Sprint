package com.farida.sprint;

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

public class WorkTaskListFragment extends Fragment {

    private ListAdapter<SprintTask, SprintAdapter.ViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView homeRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_home_task, container, false);
        adapter = new SprintAdapter();
        adapter.submitList(workTasks);
        homeRecycler.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getActivity());
        homeRecycler.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
        return homeRecycler;
    }

    public static List<SprintTask> workTasks = Arrays.asList(
            new SprintTask("Планирование рабочего дня", "dnfbjkdb"),
            new SprintTask("Эффективное сотрудничество", "kjhj"),
            new SprintTask("Приобретение новых навыков", "оамоаиоа"),
            new SprintTask("Коммуникация с руководителем", "fjgdfhgjkfdj")
    );
}
