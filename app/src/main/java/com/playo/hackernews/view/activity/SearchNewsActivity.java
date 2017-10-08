package com.playo.hackernews.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.playo.hackernews.R;
import com.playo.hackernews.presenter.SearchNewsPresenter;

public class SearchNewsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SearchNewsActivity.class.getSimpleName();
    private EditText mSearchQuery;
    private SearchNewsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        mPresenter = new SearchNewsPresenter(getApplicationContext());
    }

    private void initView() {
        mSearchQuery = (EditText) findViewById(R.id.news_search);

    }

    private void initListener() {
        findViewById(R.id.btn_search).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                try {
                    String searchValue = mSearchQuery.getText().toString().trim();
                    mPresenter.searchNews(searchValue);
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
                break;
            default:
                break;
        }
    }
}
