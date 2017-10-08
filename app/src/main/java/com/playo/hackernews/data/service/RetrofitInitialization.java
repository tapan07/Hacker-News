package com.playo.hackernews.data.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitialization {
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://hn.algolia.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
