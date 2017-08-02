package com.ljr.mycore.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by LinJiaRong on 2017/7/21.
 * TODO：
 */

public final class Latte {
    public static Configurator init(Context context) {
        Configurator.getInstance().getLatterConfigs().put(ConfigType.APPLICATION_CONTEXT,context.getApplicationContext());
        return Configurator.getInstance();
    }


    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }
    public static <T> T getConfiguration(Object key){
        return getConfigurator().getConfiguration(key);
    }
    public static Context getApplication(){
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }
}
