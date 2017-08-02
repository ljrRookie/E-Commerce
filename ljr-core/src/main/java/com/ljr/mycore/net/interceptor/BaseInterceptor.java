package com.ljr.mycore.net.interceptor;

import java.io.IOException;
import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by LinJiaRong on 2017/8/1.
 * TODO：
 */

public abstract class BaseInterceptor implements Interceptor {

    /**
     * get请求参数
     * @param chain
     * @return
     */
    protected LinkedHashMap<String, String> getUrlParameters(Chain chain) {
        final HttpUrl url = chain.request().url();
        int size = url.querySize();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(url.queryParameterName(i), url.queryParameterValue(i));
        }
        return params;
    }
    protected String getUrlParameters(Chain chain,String key){
        final Request request = chain.request();
        return request.url().queryParameter(key);
    }

    /**
     * post请求参数
     * @param chain
     * @return
     */
    protected LinkedHashMap<String,String> getBodyparameters(Chain chain){
        final FormBody formBody = (FormBody) chain.request().body();
        int size = formBody.size();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(formBody.name(i), formBody.value(i));
        }
        return params;
    }
protected String getBodyparameters(Chain chain ,String key){
    return getBodyparameters(chain).get(key);

}
}
