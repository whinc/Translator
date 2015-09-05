package com.whinc.utils;

import com.whinc.model.Word;

/**
 * Created by whinc on 2015/8/20.
 * E-mail: xiaohui_hubei@163.com
 */
public interface Translator {
    String translate(Direction from, Direction to, String source);
    Word queryWord(String word);
}
