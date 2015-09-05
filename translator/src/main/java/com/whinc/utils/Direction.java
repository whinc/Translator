package com.whinc.utils;

/**
 * Created by whinc on 2015/8/25.
 * E-mail: xiaohui_hubei@163.com
 */
public enum Direction {
    AUTO("Auto Detect"),
    ZH("Chinese"),
    EN("English"),
    JP("Japanese"),
    KOR("Korean"),
    WYW("wyw");

    private final String mLang;

    Direction(String lang) {
        mLang = lang;
    }

    public String getLang() {
        return mLang;
    }

    public String getCode() {
        return super.toString().toLowerCase();
    }
}
