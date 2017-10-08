package com.playo.hackernews.data.service;

import com.playo.hackernews.data.service.response.NewsHolder;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HackerNewsService {
    @GET("/api/v1/search")
    Call<NewsHolder> getNews(@Query("query") String category);
}
