package com.example.leaderboard.Tab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.LearningLeadersViewHolder> {

    Context context;
    List<LearningLeaders> learningLeaders;

    public LearningAdapter(Context context, List<LearningLeaders> learningLeaders) {
        this.context = context;
        this.learningLeaders = learningLeaders;
    }

    public LearningAdapter (ArrayList<LearningLeaders> learningLeaders) {
        this.learningLeaders = learningLeaders;
    }
    @NonNull
    @Override
    public LearningLeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.learning_leaders_item, parent, false);
        return new LearningLeadersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningLeadersViewHolder holder, int position) {
        LearningLeaders learningLeader = learningLeaders.get(position);
        holder.bind(learningLeader);
    }

    @Override
    public int getItemCount() {

        return learningLeaders.size();
    }

    public class LearningLeadersViewHolder extends  RecyclerView.ViewHolder{

        TextView tvLearnerName;
        TextView tvLearningHours;
        TextView tvLearnersCountry;
        ImageView topLearnerBadge;

        public LearningLeadersViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLearnerName = (TextView) itemView.findViewById(R.id.tvLearnerName);
            tvLearningHours = (TextView) itemView.findViewById(R.id.tvLearningHours);
            tvLearnersCountry = (TextView) itemView.findViewById(R.id.tvLearnersCountry);
            topLearnerBadge = (ImageView) itemView.findViewById(R.id.topLearnerBadge);
        }
        public void bind (LearningLeaders learningLeaders) {
            tvLearnerName.setText(learningLeaders.name);
            tvLearningHours.setText(learningLeaders.hours + " learning hours, ");
            tvLearnersCountry.setText(learningLeaders.country);
            Picasso.get().load(learningLeaders.getBadgeUrl()).into(topLearnerBadge);
        }
    }


}
