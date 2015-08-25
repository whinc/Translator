package com.whinc.utils;

/**
 * Created by whinc on 2015/8/25.
 * E-mail: xiaohui_hubei@163.com
 */
public enum Direction {
    AUTO("自动检测"),
    ZH("中文"),
    EN("英语"),
    JP("日语"),
    KOR("韩语"),
    WYW("文言文"),
    YUE("粤语");

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
