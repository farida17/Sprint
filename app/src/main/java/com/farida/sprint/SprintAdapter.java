package com.farida.sprint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class SprintAdapter extends ListAdapter<SprintTask, SprintAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView homeText1;
        private TextView homeText2;
        public ViewHolder(View v) {
            super(v);
            homeText1 = v.findViewById(R.id.home_text1);
            homeText2 = v.findViewById(R.id.home_text2);
        }

        void bind(SprintTask sprintTask) {
            homeText1.setText(sprintTask.getName());
            homeText2.setText(sprintTask.getRecommendation());
        }
    }

    public SprintAdapter() {
        super(new DiffUtil.ItemCallback<SprintTask>() {
            @Override
            public boolean areItemsTheSame(@NonNull SprintTask oldItem, @NonNull SprintTask newItem) {
                return oldItem.getName().equals(newItem.getName());
            }

            @Override
            public boolean areContentsTheSame(@NonNull SprintTask oldItem, @NonNull SprintTask newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @Override
    public SprintAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_text, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
