package com.playo.hackernews.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class NewsListPresenter {

    private Context mContext;

    public NewsListPresenter(Context context) {
        mContext = context;
    }

    public void getNewsDetail(String link) {
        Uri newsLink = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW, newsLink);
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(intent);
        }
    }
}
