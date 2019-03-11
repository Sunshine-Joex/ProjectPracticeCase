package cn.example.myapplication.utils.cointoast;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cn.example.myapplication.MyApplication;
import cn.example.myapplication.R;

import static cn.example.myapplication.utils.cointoast.DToast.DURATION_LONG;


public class ToastUtils {
    private static void showCommonToast(@NonNull final CharSequence text, int duration, int gravity) {
        if (MyApplication.Companion.getContext() != null) {
            View layout = LayoutInflater.from(MyApplication.Companion.getCurrentActivity()).inflate(R.layout.layout_toast, null);
            TextView contentTv = layout.findViewById(R.id.tv_content);
            contentTv.setText(text);
            DToast.make(MyApplication.Companion.getContext()).setView(layout).setDuration(duration).setGravity(gravity, 0, 300).showLong();
        } else if (MyApplication.Companion.getContext() != null) {
            View layout = LayoutInflater.from(MyApplication.Companion.getContext()).inflate(R.layout.layout_toast, null);
            TextView contentTv = layout.findViewById(R.id.tv_content);
            contentTv.setText(text);
            DToast.make(MyApplication.Companion.getContext()).setView(layout).setDuration(duration).setGravity(gravity, 0, 300).showLong();
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
        if (MyApplication.Companion.getContext() != null) {
            showCommonToast(MyApplication.Companion.getContext().getResources().getString(resId), DURATION_LONG, Gravity.BOTTOM);
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
        if (MyApplication.Companion.getContext() != null) {
            showCommonToast(MyApplication.Companion.getContext().getResources().getString(resId), DToast.DURATION_SHORT, Gravity.BOTTOM);
        }
    }

 /*   public static void showSilverToast(String text) {
        if (MyApplication.getCurrentActivity() != null) {
            View layout = LayoutInflater.from(MyApplication.getCurrentActivity()).inflate(R.layout.silver_toast, null);
            TextView contentTv = layout.findViewById(R.id.silver_score);
            contentTv.setText(text);
            DToast.make(MyApplication.getCurrentActivity()).setView(layout).setDuration(DURATION_LONG).setGravity(Gravity.CENTER).showLong();
        } else if (MyApplication.getContext() != null) {
            View layout = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.silver_toast, null);
            TextView contentTv = layout.findViewById(R.id.silver_score);
            contentTv.setText(text);
            DToast.make(MyApplication.getCurrentActivity()).setView(layout).setDuration(DURATION_LONG).setGravity(Gravity.CENTER).showLong();
        }
    }*/
}
