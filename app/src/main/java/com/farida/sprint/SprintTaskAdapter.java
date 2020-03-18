package com.farida.sprint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SprintTaskAdapter extends RecyclerView.Adapter<SprintTaskAdapter.SprintTaskViewHolder> {

    public interface OnSprintTaskClickListener {
        void onSprintTaskClick(SprintTask sprintTask);
    }

    private OnSprintTaskClickListener listener;

    SprintTaskAdapter(SprintTaskAdapter.OnSprintTaskClickListener listener) {
        this.listener = listener;
    }

    private List<SprintTask> sprintTasks;

    class SprintTaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView sprintTaskView;
        private SprintTaskViewHolder(View view) {
            super(view);
            sprintTaskView = view.findViewById(R.id.sprintTask_name);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            SprintTask current = sprintTasks.get(position);
            listener.onSprintTaskClick(current);
        }
    }

    @Override
    public SprintTaskAdapter.SprintTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sprint_tasks_list, parent, false);
        return new SprintTaskAdapter.SprintTaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SprintTaskAdapter.SprintTaskViewHolder holder, int position) {
        if (sprintTasks != null) {
            SprintTask current = sprintTasks.get(position);
            holder.sprintTaskView.setText(current.getName());
        }
    }

    void setSprintTasks(List<SprintTask> sprintTasks1) {
        sprintTasks = sprintTasks1;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(sprintTasks != null)
            return sprintTasks.size();
        else return 0;
    }
}