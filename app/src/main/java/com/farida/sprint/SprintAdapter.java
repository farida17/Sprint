package com.farida.sprint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class SprintAdapter extends ListAdapter<SprintTask, SprintAdapter.ViewHolder> {

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView homeText1;
        private TextView homeText2;
        private ImageView imageView;
        private CardView cardView;

        Listener listener;

        public ViewHolder(CardView v, Listener listener) {
            super(v);
            cardView = v;
            homeText1 = v.findViewById(R.id.home_text1);
            homeText2 = v.findViewById(R.id.home_text2);
            imageView = v.findViewById(R.id.home_picture);
            cardView.setOnClickListener(this);
            this.listener = listener;
        }

        void bind(SprintTask sprintTask) {
            homeText1.setText(sprintTask.getName());
            homeText2.setText(sprintTask.getRecommendation());
            imageView.setImageResource(sprintTask.getImage());
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(getAdapterPosition());
            }
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
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.home_text, parent, false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

}
