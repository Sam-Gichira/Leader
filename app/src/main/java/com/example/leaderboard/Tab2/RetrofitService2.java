package com.example.leaderboard.Tab2;

import com.example.leaderboard.Tab1.LearningLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService2 {
    @GET("/api/skilliq")
    Call<List<SkillLeaders>> getSkillLeadersList();
}
