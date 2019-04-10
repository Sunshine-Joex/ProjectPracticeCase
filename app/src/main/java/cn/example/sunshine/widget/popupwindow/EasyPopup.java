package cn.example.sunshine.widget.popupwindow;

import android.content.Context;
import android.view.View;
/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc   原作者github： https://github.com/zyyoona7/EasyPopup
 */

public class EasyPopup extends BasePopup<EasyPopup> {

    private OnViewListener mOnViewListener;

    public static EasyPopup create() {
        return new EasyPopup();
    }

    public static EasyPopup create(Context context) {
        return new EasyPopup(context);
    }

    public EasyPopup() {

    }

    public EasyPopup(Context context) {
        setContext(context);
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initViews(View view, EasyPopup popup) {
        if (mOnViewListener != null) {
            mOnViewListener.initViews(view, popup);
        }
    }

    public EasyPopup setOnViewListener(OnViewListener listener) {
        this.mOnViewListener = listener;
        return this;
    }

    public interface OnViewListener {

        void initViews(View view, EasyPopup popup);
    }
}
