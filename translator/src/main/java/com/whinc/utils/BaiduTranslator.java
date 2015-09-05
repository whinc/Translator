package com.whinc.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.whinc.model.Word;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by whinc on 2015/8/20.
 * E-mail: xiaohui_hubei@163.com
 */

/**
 * <a href='http://developer.baidu.com/ms/translate'>百度翻译API</a>
 */
public class BaiduTranslator implements Translator{
    private static final String TRANSLATE_URL = "http://openapi.baidu.com/public/2.0/bmt/translate";
    public static final String QUERY_WORD_URL = "http://openapi.baidu.com/public/2.0/translate/dict/simple";
    private static final String APP_KEY = "MMy04nuApNDEaIQGSV6XncBv";
    private static final String FROM = "from";
    private static final String TO = "to";
    private static final String QUERY = "q";
    private static final String CLIENT_ID = "client_id";

    private String request(String url, Direction from, Direction to, String source) {
        String result = "";
        Map<String, String> params = new HashMap<>();
        params.put(FROM, from.getCode());
        params.put(TO, to.getCode());
        params.put(CLIENT_ID, APP_KEY);
        try {
            String encodedSource = URLEncoder.encode(source, "utf-8");
            params.put(QUERY, encodedSource);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return result;
        }
        try {
            String jsonStr = HttpUtils.doGet(url, params);
            System.out.println(jsonStr);
            result = jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String translate(Direction from, Direction to, String source) {
        String jsonStr = request(TRANSLATE_URL, from, to, source);
        return parseJson(jsonStr);
    }

    @Override
    public Word queryWord(String word) {
        String jsonStr = request(QUERY_WORD_URL, Direction.EN, Direction.ZH, word);
        return JSON.parseObject(jsonStr, Word.class);
    }

    private String parseJson(String jsonStr) {
        StringBuilder builder = new StringBuilder();
        JSONObject jsonObject = (JSONObject) JSON.parse(jsonStr);
        String errorCode = jsonObject.getString("error_code");

        if (errorCode == null) {    // 没有发生错误
            JSONArray jsonArray = jsonObject.getJSONArray("trans_result");
            for (Object obj : jsonArray) {
                JSONObject tmpObj = (JSONObject) obj;
                String dst = tmpObj.getString("dst");
                try {
                    builder.append(URLDecoder.decode(dst, "utf-8")).append('\n');
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return builder.toString();
    }


}
