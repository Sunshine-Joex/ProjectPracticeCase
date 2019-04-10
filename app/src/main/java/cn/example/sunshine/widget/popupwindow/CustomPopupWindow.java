package cn.example.sunshine.widget.popupwindow;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/**
 * @author SunShine-Joex
 * @date 2018/11/16
 * @desc Android 7.0/7.1 pop弹出的时候bug
 */

public class CustomPopupWindow extends PopupWindow {
    public CustomPopupWindow(Context context) {
        super(context, null);
    }

    /**
     * android 7.0系统bug
     *
     * @param anchor
     */
    @Override
    public void showAsDropDown(View anchor) {
        if (Build.VERSION.SDK_INT == 24) {
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            setHeight(h);
        }
        super.showAsDropDown(anchor);
    }


}
