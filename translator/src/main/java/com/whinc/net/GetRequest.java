package com.whinc.net;

/**
 * Created by whinc on 2015/8/22.
 * E-mail: xiaohui_hubei@163.com
 */
public interface GetRequest extends RequestBase{
    GetRequest addQuery(String key, String value);
    GetRequest removeQuery(String key);
}
