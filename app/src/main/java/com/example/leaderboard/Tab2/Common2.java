package com.example.leaderboard.Tab2;

import com.example.leaderboard.Tab1.HoursApiUtil;
import com.example.leaderboard.Tab1.RetrofitService1;

public class Common2 {
    private  static final String BASE_URL = "https://gadsapi.herokuapp.com";

    public  static RetrofitService2 getSkillLeaders() {
        return  SkillApiUtil.getClient(BASE_URL).create(RetrofitService2.class);
    }
}
