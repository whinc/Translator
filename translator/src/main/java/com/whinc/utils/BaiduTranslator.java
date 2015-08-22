package com.whinc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by whinc on 2015/8/20.
 * E-mail: xiaohui_hubei@163.com
 */
public class BaiduTranslator implements Translator{
    private static final String SERVER_URL = "http://openapi.baidu.com/public/2.0/bmt/translate";

    @Override
    public String translate(String from, String to, String source) {
        try {
            URL url = new URL(SERVER_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("from", from);
            httpURLConnection.setRequestProperty("to", to);
            httpURLConnection.setRequestProperty("client_id", "MMy04nuApNDEaIQGSV6XncBv");
            httpURLConnection.setRequestProperty("q", source);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                StringBuilder builder = new StringBuilder();
                while (scanner.hasNextLine()) {
                    builder.append(scanner.nextLine());
                }
                System.out.println(builder);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
