package com.playo.hackernews.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.playo.hackernews.R;
import com.playo.hackernews.data.service.response.Hit;
import com.playo.hackernews.presenter.NewsListPresenter;
import com.playo.hackernews.view.adapter.NewsListAdapter;
import com.playo.hackernews.view.listener.NewsSelectionListener;

import java.util.ArrayList;

public class NewsListActivity extends AppCompatActivity implements NewsSelectionListener {

    private RecyclerView mNewsView;
    private ArrayList<Hit> mNewsList;
    private NewsListPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        initUi();
        setAdapter();
        mPresenter = new NewsListPresenter(getApplicationContext());
    }

    private void setAdapter() {
        mNewsList = getIntent().getParcelableArrayListExtra("news");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mNewsView.setLayoutManager(manager);
        NewsListAdapter mAdapter = new NewsListAdapter(this, mNewsList);
        mNewsView.setAdapter(mAdapter);

    }

    private void initUi() {
        mNewsView = (RecyclerView) findViewById(R.id.news_list);
    }

    @Override
    public void onItemSelection(int position) {
        mPresenter.getNewsDetail(mNewsList.get(position).getUrl());
    }

}
