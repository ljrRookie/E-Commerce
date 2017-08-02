package com.ljr.mycore.net;

import android.content.Context;
import android.provider.MediaStore;
import android.telecom.TelecomManager;

import com.ljr.mycore.net.callback.IError;
import com.ljr.mycore.net.callback.IFailure;
import com.ljr.mycore.net.callback.IRequest;
import com.ljr.mycore.net.callback.ISuccess;
import com.ljr.mycore.ui.LoaderStyle;

import java.io.File;
import java.math.MathContext;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by LinJiaRong on 2017/7/25.
 * TODO：
 */

public class RestClientBuilder {
    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;
    private File mFile = null;

    RestClientBuilder() {
    }


    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }


    public final RestClientBuilder params(WeakHashMap<String, Object> val) {
        PARAMS.putAll(val);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }
    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder name(String name){
        this.mName = name;
        return this;
    }
    public final RestClientBuilder dir(String dir){
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension){
        this.mExtension = extension;
        return this;
    }


    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder request(IRequest val) {
        this.mIRequest = val;
        return this;
    }

    public final RestClientBuilder success(ISuccess val) {
        this.mISuccess = val;
        return this;
    }

    public final RestClientBuilder failure(IFailure val) {
        this.mIFailure = val;
        return this;
    }

    public final RestClientBuilder error(IError val) {
        this.mIError = val;
        return this;
    }

    public final RestClientBuilder body(RequestBody val) {
        this.mBody = val;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.mContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mIRequest,mDownloadDir, mExtension,mName, mISuccess, mIFailure, mIError, mBody,mFile, mContext, mLoaderStyle);
    }

}
