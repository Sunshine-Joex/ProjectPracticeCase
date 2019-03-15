package cn.example.myapplication.widget.popupwindow;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/**
 * @author qly
 * @date 2018/11/16
 * @desc
 */
public class CustomPopupWindow extends PopupWindow {
    public CustomPopupWindow(Context context) {
        super(context, null);
    }

    /**
     * android 7.0系统bug
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
