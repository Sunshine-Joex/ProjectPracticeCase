package cn.example.myapplication.utils.cointoast;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cn.example.myapplication.MyApplication;


public class ToastUtils {
    private static void showCommonToast(@NonNull final CharSequence text, int duration, int gravity) {
        if (MyApplication.Companion.getCurrentActivity() != null) {
            View layout = LayoutInflater.from(GlobalData.getActivity()).inflate(R.layout.layout_toast, null);
            TextView contentTv = layout.findViewById(R.id.tv_content);
            contentTv.setText(text);
            DToast.make(GlobalData.getActivity()).setView(layout).setDuration(duration).setGravity(gravity, 0, 300).showLong();
        } else if (GlobalData.sContext != null) {
            View layout = LayoutInflater.from(GlobalData.sContext).inflate(R.layout.layout_toast, null);
            TextView contentTv = layout.findViewById(R.id.tv_content);
            contentTv.setText(text);
            DToast.make(GlobalData.getActivity()).setView(layout).setDuration(duration).setGravity(gravity, 0, 300).showLong();
        }
    }

    /**
     * Show the toast for a long period of time.
     *
     * @param text The text.
     */
    public static void showLong(@NonNull final CharSequence text) {
        showCommonToast(text, DURATION_LONG, Gravity.BOTTOM);
    }

    /**
     * Show the toast for a long period of time.
     *
     * @param resId The resource id for text.
     */
    public static void showLong(@StringRes final int resId) {
        if (GlobalData.sContext != null) {
            showCommonToast(GlobalData.sContext.getResources().getString(resId), DURATION_LONG, Gravity.BOTTOM);
        }
    }

    /**
     * Show the toast for a short period of time.
     *
     * @param text The text.
     */
    public static void showShort(@NonNull final CharSequence text) {
        showCommonToast(text, DToast.DURATION_SHORT, Gravity.BOTTOM);
    }

    /**
     * Show the toast for a short period of time.
     *
     * @param resId The resource id for text.
     */
    public static void showShort(@StringRes final int resId) {
        if (GlobalData.sContext != null) {
            showCommonToast(GlobalData.sContext.getResources().getString(resId), DToast.DURATION_SHORT, Gravity.BOTTOM);
        }
    }

    public static void showSilverToast(String text) {
        if (GlobalData.getActivity() != null) {
            View layout = LayoutInflater.from(GlobalData.getActivity()).inflate(R.layout.silver_toast, null);
            TextView contentTv = layout.findViewById(R.id.silver_score);
            contentTv.setText(text);
            DToast.make(GlobalData.getActivity()).setView(layout).setDuration(DURATION_LONG).setGravity(Gravity.CENTER).showLong();
        } else if (GlobalData.sContext != null) {
            View layout = LayoutInflater.from(GlobalData.sContext).inflate(R.layout.silver_toast, null);
            TextView contentTv = layout.findViewById(R.id.silver_score);
            contentTv.setText(text);
            DToast.make(GlobalData.getActivity()).setView(layout).setDuration(DURATION_LONG).setGravity(Gravity.CENTER).showLong();
        }
    }
}
