package com.farida.sprint;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class RelationshipTaskListFragment extends Fragment implements SprintAdapter.Listener {

    private ListAdapter<SprintTask, SprintAdapter.ViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView relationshipRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_home_task, container, false);
        adapter = new SprintAdapter();
        adapter.submitList(relationshipTasks);
        relationshipRecycler.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getActivity());
        relationshipRecycler.setLayoutManager(layoutManager);


        return relationshipRecycler;
    }

    public List<SprintTask> relationshipTasks = Arrays.asList(
            new SprintTask("Уборка", "dnfbjkdb", R.drawable.ndbfjhdfbv),
            new SprintTask("Мытье посуды", "kjhj", R.drawable.ndbfjhdfbv),
            new SprintTask("Стирка", "оамоаиоа", R.drawable.ndbfjhdfbv),
            new SprintTask("Мытье окон", "fjgdfhgjkfdj", R.drawable.ndbfjhdfbv)
    );

    @Override
    public void onClick(int position) {

    }
}
