package com.ljr.e_commerce;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.ljr.ec.icon.FontEcModule;
import com.ljr.mycore.app.Latte;
import com.ljr.mycore.net.interceptor.DebugInterceptor;

/**
 * Created by LinJiaRong on 2017/7/21.
 * TODO：
 */

public class ECApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();
    }
}
