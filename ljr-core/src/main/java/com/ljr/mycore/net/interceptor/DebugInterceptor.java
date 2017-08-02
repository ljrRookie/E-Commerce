package com.ljr.mycore.net.interceptor;

import android.os.FileUriExposedException;
import android.support.annotation.RawRes;

import com.ljr.mycore.utils.FileUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by LinJiaRong on 2017/8/1.
 * TODO：
 */

public class DebugInterceptor extends BaseInterceptor {
    private final String DEBUG_URL;

    private final int DEBUG_RAW_ID;

    public DebugInterceptor(String debug_url, int debug_raw_id) {
        this.DEBUG_URL = debug_url;
        this.DEBUG_RAW_ID = debug_raw_id;
    }
private Response getResponse(Chain chain,String json){
    return new Response.Builder()
            .code(200)
            .addHeader("Content-Type","application/json")
            .body(ResponseBody.create(MediaType.parse("application/json"),json))
            .message("ok")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .build();
}
private Response debugResponse(Chain chain, @RawRes int rawId){
    final String json = FileUtil.getRawFile(rawId);
    return getResponse(chain,json);


}
    @Override
    public Response intercept(Chain chain) throws IOException {
        final String url = chain.request().url().toString();
        if(url.contains(DEBUG_URL)){
            return debugResponse(chain,DEBUG_RAW_ID);
        }
        return chain.proceed(chain.request());
    }
}
