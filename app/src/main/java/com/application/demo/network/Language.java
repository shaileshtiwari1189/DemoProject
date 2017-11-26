package com.application.demo.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shailesh on 24/11/17.
 */

public class Language {
    @SerializedName("name")
    private String name;
    @SerializedName("icon")
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
