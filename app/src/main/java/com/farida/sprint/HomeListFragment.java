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


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeListFragment extends Fragment {

    private ListAdapter<HomeTask, HomeAdapter.ViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView homeRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_home_list, container, false);
        adapter = new HomeAdapter();
        adapter.submitList(homeTasks);
        homeRecycler.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getActivity());
        homeRecycler.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
        return homeRecycler;
    }


    public static List<HomeTask> homeTasks = Arrays.asList(
            new HomeTask("Уборка", "dnfbjkdb"),
            new HomeTask("Мытье посуды", "kjhj"),
            new HomeTask("Стирка", "оамоаиоа"),
            new HomeTask("Мытье окон", "fjgdfhgjkfdj")
    );
}
