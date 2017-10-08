package com.playo.hackernews.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.playo.hackernews.R;
import com.playo.hackernews.data.service.response.Hit;
import com.playo.hackernews.view.listener.NewsSelectionListener;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private Context mContext;
    private List<Hit> mNewsList;
    private NewsSelectionListener mListener;

    public NewsListAdapter(Context context, List<Hit> newsList) {
        mListener = (NewsSelectionListener) context;
        mNewsList = newsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hit result = mNewsList.get(position);
        holder.mNewsTitle.setText(result.getTitle());
        holder.mAuthor.setText(result.getAuthor());

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNewsTitle;
        private TextView mAuthor;
        private CardView mNewsItem;

        public ViewHolder(View view) {
            super(view);
            mNewsTitle = (TextView) view.findViewById(R.id.news_title);
            mAuthor = (TextView) view.findViewById(R.id.news_author);
            mNewsItem = (CardView) view.findViewById(R.id.news_item);
            mNewsItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.news_item:
                    mListener.onItemSelection(getAdapterPosition());
                    break;
            }
        }
    }
}
