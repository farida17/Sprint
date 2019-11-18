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


public class DevelopmentTaskListFragment extends Fragment implements SprintAdapter.Listener {

    private SprintAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView developmentRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_home_task, container, false);
        adapter = new SprintAdapter();
        adapter.submitList(developmentTasks);
        developmentRecycler.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getActivity());
        developmentRecycler.setLayoutManager(layoutManager);

        adapter.setListener(this);
        return developmentRecycler;
    }

    public static List<SprintTask> developmentTasks = Arrays.asList(
            new SprintTask("Изучение иностранного языка", "dnfbjkdb", R.drawable.ndbfjhdfbv),
            new SprintTask("Курсы для профессионального роста", "kjhj", R.drawable.ndbfjhdfbv),
            new SprintTask("Кулинарный мастер-класс", "оамоаиоа", R.drawable.ndbfjhdfbv),
            new SprintTask("Коммуникация с руководителем", "fjgdfhgjkfdj", R.drawable.ndbfjhdfbv)
    );

    @Override
    public void onClick(int position) {

    }
}

