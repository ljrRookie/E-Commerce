package com.ljr.e_commerce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.ljr.mycore.delegates.LatteDelegate;
import com.ljr.mycore.net.RestClient;
import com.ljr.mycore.net.callback.IError;
import com.ljr.mycore.net.callback.IFailure;
import com.ljr.mycore.net.callback.ISuccess;

/**
 * Created by LinJiaRong on 2017/7/25.
 * TODO：
 */

public class MainDelegate extends LatteDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
testRestClient();
    }
    private void testRestClient(){
        RestClient.builder()
                .url("http://news.baidu.com/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
        .get();
    }

}
