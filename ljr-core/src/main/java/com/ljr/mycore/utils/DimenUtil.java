package com.ljr.mycore.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.ljr.mycore.app.Latte;

/**
 * Created by LinJiaRong on 2017/7/26.
 * TODO：获取设备宽高
 */

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
