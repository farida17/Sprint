package com.farida.sprint;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.health_button)
    void onHealthClicked () {
        getFragmentManager().beginTransaction()
            .replace(R.id.container, new HealthTaskListFragment())
            .addToBackStack(null)
            .commit();
    }

    @OnClick(R.id.home_button)
    void onHomeClicked() {
        getFragmentManager().beginTransaction()
            .replace(R.id.container, new HomeTaskListFragment())
            .addToBackStack(null)
            .commit();
    }

    @OnClick(R.id.work_button)
    void onWorkClicked() {
        getFragmentManager().beginTransaction()
            .replace(R.id.container, new WorkTaskListFragment())
            .addToBackStack(null)
            .commit();
    }

    @OnClick(R.id.development_button)
    void onDevelopmentClicked() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new DevelopmentTaskListFragment())
                .addToBackStack(null)
                .commit();
    }

    @OnClick(R.id.hobby_button)
    void onHobbyClicked() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new HobbyTaskListFragment())
                .addToBackStack(null)
                .commit();
    }

    @OnClick(R.id.relationship_button)
    void onRelationshipClicked() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new RelationshipTaskListFragment())
                .addToBackStack(null)
                .commit();
    }
}
