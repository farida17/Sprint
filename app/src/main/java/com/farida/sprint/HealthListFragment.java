package com.farida.sprint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HealthListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView healthRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_health, container, false);

        String[] healthNames = new String[HealthList.healthLists.length];
        for (int i = 0; i < healthNames.length; i++) {
            healthNames[i] = HealthList.healthLists[i].getName();
        }
        int[] healthImages = new int[HealthList.healthLists.length];
        for (int i = 0; i < healthImages.length; i++) {
            healthImages[i] = HealthList.healthLists[i].getImage();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(healthNames, healthImages);
        healthRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        healthRecycler.setLayoutManager(layoutManager);

        /*adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), HealthListDetailActivity.class);
                intent.putExtra(HealthListDetailActivity.EXTRA_HEALTH_ID, position);
                getActivity().startActivity(intent);
            }
        });*/
        return healthRecycler;

        }
}


