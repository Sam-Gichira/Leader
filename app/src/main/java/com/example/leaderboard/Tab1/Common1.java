package com.example.leaderboard.Tab1;

import com.example.leaderboard.Tab1.HoursApiUtil;
import com.example.leaderboard.Tab1.RetrofitService1;

public class Common1 {
    private  static final String BASE_URL = "https://gadsapi.herokuapp.com";

    public  static RetrofitService1 getLearningLeaders() {
        return  HoursApiUtil.getClient(BASE_URL).create(RetrofitService1.class);
    }
}
