package com.farida.sprint.sprintType;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farida.sprint.R;
import com.farida.sprint.entity.SprintType;

import java.util.List;

public class SprintTypeAdapter extends RecyclerView.Adapter<SprintTypeAdapter.SprintTypeViewHolder> {

    public interface OnSprintTypeClickListener {
        void onSprintTypeClick(SprintType sprintType);
    }

    private OnSprintTypeClickListener listener;

    SprintTypeAdapter(OnSprintTypeClickListener listener) {
        this.listener = listener;
    }

    class SprintTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView sprintTypeView;
        private SprintTypeViewHolder(View view) {
            super(view);
            sprintTypeView = view.findViewById(R.id.sprintType);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            SprintType sprintType = sprintTypes.get(position);
            listener.onSprintTypeClick(sprintType);
        }
    }

    private List<SprintType> sprintTypes;

    @NonNull
    @Override
    public SprintTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sprint_types_list, parent, false);
        return new SprintTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SprintTypeAdapter.SprintTypeViewHolder holder, int position) {
        if (sprintTypes != null) {
            SprintType current = sprintTypes.get(position);
            holder.sprintTypeView.setText(current.getSprintTypeName());
        }
    }

    void setSprintTypes(List<SprintType> sprintTypes1) {
        sprintTypes = sprintTypes1;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(sprintTypes != null)
            return sprintTypes.size();
        else return 0;
    }
}
