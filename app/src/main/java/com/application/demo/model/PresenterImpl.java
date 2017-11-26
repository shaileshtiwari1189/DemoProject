package com.application.demo.model;

import android.util.Log;

import com.application.demo.network.Language;
import com.application.demo.network.LanguageResponse;
import com.application.demo.network.Response;
import com.application.demo.presenter.Presenter;
import com.application.demo.rest.ApiClient;
import com.application.demo.rest.BackendApi;
import com.application.demo.view.LoadMoreView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Shailesh on 24/11/17.
 */

public class PresenterImpl implements Presenter {
    private LoadMoreView loadMoreView;
    private int currentPage =1;
    private boolean isLastPage;
    private ArrayList<Language> langList = new ArrayList<>();
    public PresenterImpl(LoadMoreView view) {
        loadMoreView = view;
    }

    @Override
    public void loadData(int page) {
        loadMoreView.showProgress(true);
        int previousCount = langList.size();
        loadMoreView.showPreviousCount(previousCount);
       Call<Response>  responseCall = BackendApi.API.getProgramingLanuages(page);

        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                loadMoreView.showProgress(false);
                LanguageResponse languageResponse = response.body().getResponse();
                langList.addAll(languageResponse.getResults());
                loadMoreView.showLanguages(languageResponse.getResults());
                if(languageResponse.getTotalPages()==currentPage){
                    isLastPage =true;
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                loadMoreView.showProgress(false);
                Log.v("TAG",t.getMessage());
            }
        });

    }

    @Override
    public void onLoadNext() {
        currentPage++;
        if(!isLastPage)
         loadData(currentPage);
    }
}
