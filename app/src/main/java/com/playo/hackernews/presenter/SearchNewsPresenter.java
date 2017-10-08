package com.playo.hackernews.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.playo.hackernews.R;
import com.playo.hackernews.data.service.HackerNewsService;
import com.playo.hackernews.data.service.RetrofitInitialization;
import com.playo.hackernews.data.service.response.Hit;
import com.playo.hackernews.data.service.response.NewsHolder;
import com.playo.hackernews.view.activity.NewsListActivity;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchNewsPresenter {

    private Context mContext;

    public SearchNewsPresenter(Context context) {
        mContext = context;
    }

    private void getNews(String searchValue) throws IOException {
        HackerNewsService newsService = RetrofitInitialization.retrofit.create(HackerNewsService.class);

        Call<NewsHolder> call = newsService.getNews(searchValue);

        call.enqueue(new Callback<NewsHolder>() {
            @Override
            public void onResponse(Call<NewsHolder> call, Response<NewsHolder> response) {
                NewsHolder news = response.body();

                Intent intent = new Intent(mContext, NewsListActivity.class);
                ArrayList<Hit> result = (ArrayList<Hit>) news.getHits();
                intent.putParcelableArrayListExtra("news", result);
                mContext.startActivity(intent);
            }

            @Override
            public void onFailure(Call<NewsHolder> call, Throwable t) {
                showErrorMessage();

            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(mContext, mContext.getResources().getString(R.string.no_result_found), Toast.LENGTH_LONG).show();
    }

    public void searchNews(String searchValue) throws IOException {
        if (!TextUtils.isEmpty(searchValue)) {
            getNews(searchValue);
        } else {
            showErrorMessage();
        }
    }
}
