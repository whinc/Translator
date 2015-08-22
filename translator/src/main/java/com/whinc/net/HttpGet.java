package com.whinc.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by whinc on 2015/8/22.
 * E-mail: xiaohui_hubei@163.com
 */
public class HttpGet implements GetRequest{
    private Map<String, String> mQuerys = new HashMap<>();

    @Override
    public GetRequest addQuery(String key, String value) {
        mQuerys.put(key, value);
        return this;
    }

    @Override
    public GetRequest removeQuery(String key) {
        mQuerys.remove(key);
        return this;
    }

    @Override
    public byte[] execute(String url) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setConnectTimeout(20 * 1000);
            httpURLConnection.setReadTimeout(10 * 1000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
