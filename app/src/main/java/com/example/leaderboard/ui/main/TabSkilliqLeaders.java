package com.example.leaderboard.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.R;
import com.example.leaderboard.Tab2.Common2;
import com.example.leaderboard.Tab2.RetrofitService2;
import com.example.leaderboard.Tab2.SkillAdapter;
import com.example.leaderboard.Tab2.SkillLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class TabSkilliqLeaders extends Fragment {
    RetrofitService2 mService2;
    SkillAdapter mAdapter;
    RecyclerView rvSkillLeaders;
    RecyclerView.LayoutManager layoutManager;
    View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.skill_iq_leaders, container, false);
        mService2 = Common2.getSkillLeaders();
        rvSkillLeaders = (RecyclerView) root.findViewById(R.id.rvSkillLeaders);
        rvSkillLeaders.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(null);
        rvSkillLeaders.setLayoutManager(layoutManager);

        getAllSkillList ();
        return root;

    }

    private void getAllSkillList() {
        mService2.getSkillLeadersList().enqueue(new Callback<List<SkillLeaders>>() {
            @Override
            public void onResponse(Call<List<SkillLeaders>> call, Response<List<SkillLeaders>> response) {
                mAdapter = new SkillAdapter(getContext(), response.body());
                mAdapter.notifyDataSetChanged();
                rvSkillLeaders.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<SkillLeaders>> call, Throwable t) {

            }
        });
    }
}