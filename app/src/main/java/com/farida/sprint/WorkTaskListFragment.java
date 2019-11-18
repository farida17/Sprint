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

public class WorkTaskListFragment extends Fragment implements SprintAdapter.Listener {

    private SprintAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView workRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_home_task, container, false);
        adapter = new SprintAdapter();
        adapter.submitList(workTasks);
        workRecycler.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getActivity());
        workRecycler.setLayoutManager(layoutManager);

        adapter.setListener(this);

        return workRecycler;
    }

    public static List<SprintTask> workTasks = Arrays.asList(
            new SprintTask("Планирование рабочего дня", "dnfbjkdb", R.drawable.ndbfjhdfbv),
            new SprintTask("Эффективное сотрудничество", "kjhj", R.drawable.ndbfjhdfbv),
            new SprintTask("Приобретение новых навыков", "оамоаиоа", R.drawable.ndbfjhdfbv),
            new SprintTask("Коммуникация с руководителем", "fjgdfhgjkfdj", R.drawable.ndbfjhdfbv)
    );

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(), WorkTaskDetailActivity.class);
        intent.putExtra(WorkTaskDetailActivity.EXTRA_WORK_ID, position);
        startActivity(intent);
    }
}

