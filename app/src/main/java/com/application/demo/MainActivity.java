package com.application.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.application.demo.adapter.LanguageAdapter;
import com.application.demo.model.PresenterImpl;
import com.application.demo.network.Language;
import com.application.demo.view.LoadMoreView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements LoadMoreView {
    private static final int FIRST_PAGE = 1;
    private Unbinder unbinder;
    private PresenterImpl presenter;
    private LanguageAdapter languageAdapter;


    @BindView(R.id.my_recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.progress) ProgressBar mProgress;
    private int previousTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        presenter = new PresenterImpl(this);
        languageAdapter = new LanguageAdapter(this);
        presenter.loadData(FIRST_PAGE);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(languageAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = mRecyclerView.getLayoutManager().getChildCount();
                int totalItemCount = mRecyclerView.getLayoutManager().getItemCount();
                int firstVisibleItemPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (totalItemCount == (firstVisibleItemPosition + visibleItemCount) && totalItemCount > previousTotal) {
                      loadMore();
                }
            }
                
                
            


        });

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showPreviousCount(int previousCount) {
        previousTotal = previousCount;
    }

    @Override
    public void loadMore() {
        presenter.onLoadNext();

    }

    @Override
    public void showLanguages(List<Language> languages) {
        mRecyclerView.setVisibility(View.VISIBLE);
        languageAdapter.setLanguage(languages);
        refresh();

    }

    @Override
    public void showProgress(boolean isProgress) {
        if (isProgress) {
            mProgress.setVisibility(View.VISIBLE);
        } else {
            mProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void refresh() {
     languageAdapter.refresh();
    }
}
