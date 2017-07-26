package com.ljr.mycore.app;

import android.graphics.Bitmap;
import android.view.LayoutInflater;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by LinJiaRong on 2017/7/21.
 * TODO：配置文件
 */

public class Configurator {
    private static final HashMap<String,Object> LATTE_CONFIGS =new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    public Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);

    }

    final HashMap<String, Object> getLatterConfig() {
        return LATTE_CONFIGS;
    }

    //单例模式
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }
    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    //配置完成
    public final void configure(){
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }
    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }
    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;

    }
    //初始化icons
    private void initIcons(){
        if(ICONS.size()>0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i <ICONS.size() ; i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    //检查是否配置完成
    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready , call Configure");
        }
    }
   @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());

    }
}
