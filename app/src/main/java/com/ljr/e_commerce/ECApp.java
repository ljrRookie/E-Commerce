package com.ljr.e_commerce;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.ljr.ec.icon.FontEcModule;
import com.ljr.mycore.app.Latte;

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
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
