package com.whinc.model;

import java.util.List;

/**
 * Created by whinc on 2015/9/4.
 * E-mail: xiaohui_hubei@163.com
 */
public class Part {
    private List<String> means;

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public List<String> getMeans() {
        return means;
    }

    public void setMeans(List<String> means) {
        this.means = means;
    }

    private String part;
}
