package com.application.demo.adapter.model;

import com.application.demo.network.Language;

import java.util.List;

/**
 * Created by Shailesh on 24/11/17.
 */

public interface LogoDataModel {

    Language getLanguage(int position);

    void setLanguage(List<Language> languageList);

    int getSize();

    public interface LanguageAdapterView {
        void refresh();
    }

}
