package com.example.leaderboard.Tab2;

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

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillLeadersViewHolder> {


    Context context;
    List<SkillLeaders> skillLeaders;

    public SkillAdapter(Context context, List<SkillLeaders> skillLeaders) {
        this.context = context;
        this.skillLeaders = skillLeaders;
    }

    public SkillAdapter(ArrayList<SkillLeaders> skillLeaders) {
        this.skillLeaders = skillLeaders;
    }
    @NonNull
    @Override
    public SkillAdapter.SkillLeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.skill_iq_item, parent, false);
        return new SkillAdapter.SkillLeadersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAdapter.SkillLeadersViewHolder holder, int position) {
        SkillLeaders skillLeader = skillLeaders.get(position);
        holder.bind(skillLeader);
    }

    @Override
    public int getItemCount() {

        return skillLeaders.size();
    }

    public class SkillLeadersViewHolder extends  RecyclerView.ViewHolder{

        TextView textLearnerName;
        TextView tvLearningSkill;
        TextView textLearnersCountry;
        ImageView skillBadge;

        public SkillLeadersViewHolder(@NonNull View itemView) {
            super(itemView);
            textLearnerName = (TextView) itemView.findViewById(R.id.textLearnerName);
            tvLearningSkill = (TextView) itemView.findViewById(R.id.tvLearningSkill);
            textLearnersCountry = (TextView) itemView.findViewById(R.id.textLearnersCountry);
            skillBadge = (ImageView) itemView.findViewById(R.id.skillBadge);
        }
        public void bind (SkillLeaders skillLeaders) {
            textLearnerName.setText(skillLeaders.name);
            tvLearningSkill.setText(skillLeaders.score + " skill IQ Score, ");
            textLearnersCountry.setText(skillLeaders.country);
            Picasso.get().load(skillLeaders.getBadgeUrl()).into(skillBadge);
        }
    }


}


