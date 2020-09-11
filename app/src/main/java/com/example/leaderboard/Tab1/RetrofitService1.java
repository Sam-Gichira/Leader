package com.example.leaderboard.Tab1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService1 {
    @GET("/api/hours")
    Call<List<LearningLeaders>> getLearningLeadersList();
}
