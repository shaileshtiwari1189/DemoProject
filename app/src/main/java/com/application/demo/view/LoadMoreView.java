package com.application.demo.view;

import com.application.demo.network.Language;

import java.util.List;

/**
 * Created by Shailesh on 24/11/17.
 */

public interface LoadMoreView {
    void showPreviousCount(int previousCount);
    void loadMore();
    void refresh();
    void showLanguages(List<Language> languages);
    void showProgress(boolean isProgress);
}
