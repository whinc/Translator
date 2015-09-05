package com.whinc.model;

import java.util.List;

/**
 * Created by whinc on 2015/9/4.
 * E-mail: xiaohui_hubei@163.com
 */
public class Data {
    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public String getWord_name() {
        return word_name;
    }

    public void setWord_name(String word_name) {
        this.word_name = word_name;
    }

    private List<Symbol> symbols;
    private String word_name;
}
