package com.whinc.model;

/**
 * Created by whinc on 2015/9/4.
 * E-mail: xiaohui_hubei@163.com
 */
public class Word {
    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private int errno;
    private String from;
    private String to;
    private Data data;
}
