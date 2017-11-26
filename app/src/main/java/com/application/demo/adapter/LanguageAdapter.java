package com.application.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.demo.R;
import com.application.demo.adapter.model.LogoDataModel;
import com.application.demo.network.Language;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LangauageViewHolder> implements LogoDataModel, LogoDataModel.LanguageAdapterView {

    private Context context;
    private List<Language> languages = new ArrayList<>();

    public LanguageAdapter(Context context) {
     this.context = context;
    }

    @Override
    public LangauageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_language, parent, false);
        return new LangauageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LangauageViewHolder holder, int position) {
        Language language = getLanguage(position);
        holder.lblLangaugeName.setText(language.getName());
        ImageLoader.getInstance().displayImage(language.getIcon(), holder.imgLogo);

    }

    @Override
    public int getItemCount() {
        return getSize();
    }

    @Override
    public Language getLanguage(int position) {
        return languages.get(position);
    }

    @Override
    public void setLanguage(List<Language> languageList) {
        this.languages.addAll(languageList);
    }

    @Override
    public int getSize() {
        if (languages != null)
            return languages.size();
        return 0;
    }

    @Override
    public void refresh() {
        notifyDataSetChanged();
    }


    class LangauageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgLogo)
        ImageView imgLogo;
        @BindView(R.id.lbl_language)
        TextView lblLangaugeName;

        public LangauageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
