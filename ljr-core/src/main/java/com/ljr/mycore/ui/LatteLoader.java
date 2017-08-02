package com.ljr.mycore.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


import com.ljr.mycore.R;
import com.ljr.mycore.utils.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by LinJiaRong on 2017/7/26.
 * TODO：
 */

public class LatteLoader {
    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;
    //默认loading样式
    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();

    /**
     * 创建dialog
     * @param context
     * @param type
     */
    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);
        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();
        final Window dialogWindow = dialog.getWindow();

        if (dialogWindow!=null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width=deviceWidth/LOADER_SIZE_SCALE;
            lp.height=deviceHeight/LOADER_SIZE_SCALE;
            lp.height = lp.height+deviceHeight/LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    /**
     * 自定义样式dialog
     * @param context
     * @param type
     */
    public static void showLoading(Context context,Enum<LoaderStyle> type){
    showLoading(context,type.name());
    }

    /**
     * 默认样式dialog
     * @param context
     */
    public static void showLoading(Context context){
        showLoading(context,DEFAULT_LOADER);
    }

    /**
     * 隐藏dialog
     */
    public static void stopLoading(){
        for(AppCompatDialog dialog:LOADERS){
            if(dialog!=null){
                if(dialog.isShowing()){
                    dialog.cancel();
                }
            }
        }
    }

}
