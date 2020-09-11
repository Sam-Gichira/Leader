package com.example.leaderboard.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.Tab1.Common1;
import com.example.leaderboard.R;
import com.example.leaderboard.Tab1.LearningAdapter;
import com.example.leaderboard.Tab1.LearningLeaders;
import com.example.leaderboard.Tab1.RetrofitService1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class TabLearningLeaders extends Fragment {
    TextView textError;
    RetrofitService1 mService1;
    LearningAdapter adapter;
    RecyclerView rvLearningLeaders;
    RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar mLoadingProgress;
    View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.learning_leaders, container, false);
        textError = (TextView) root.findViewById(R.id.tv_error);
        mLoadingProgress = (ProgressBar) root.findViewById(R.id.pb_loading);
        mService1 = Common1.getLearningLeaders();
        rvLearningLeaders = (RecyclerView) root.findViewById(R.id.rvLearningLeaders);
        rvLearningLeaders.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(null);
        rvLearningLeaders.setLayoutManager(mLayoutManager);

        getAllLeadersList();


        return root;
    }

    private void getAllLeadersList() {
        mService1.getLearningLeadersList().enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                if (!response.isSuccessful()) {
                    textError.setVisibility(View.VISIBLE);
                    textError.setText("code: "+ response.code());
                    return;
                } textError.setVisibility(View.INVISIBLE);


                adapter = new LearningAdapter(getContext(), response.body());
                adapter.notifyDataSetChanged();
                rvLearningLeaders.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {
                textError.setText("Error Occurred");
            }
        });
    }
}