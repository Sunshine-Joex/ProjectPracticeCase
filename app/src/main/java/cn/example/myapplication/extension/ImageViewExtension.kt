package cn.example.myapplication.extension

import android.graphics.Color
import android.widget.ImageView
import cn.example.myapplication.MyApplication
import cn.example.myapplication.utils.GlideCircleTransform
import cn.example.myapplication.utils.RoundTransformation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * @author SunShine-Joex
 * @date   2019/3/14
 * @desc   图片加载扩展方法
 */

/**
 *　加载圆形图\圆形边框图(tips:若后面两个参数省略就是不带边框，若设置则是)
 */
fun ImageView.loadBorderCircleImage(url: String, borderWidth: Float = 0.0f, borderColor: Int = Color.TRANSPARENT) {
    val options = RequestOptions().transform(GlideCircleTransform(MyApplication.getContext(), borderWidth, borderColor))
    Glide.with(MyApplication.getContext())
            .load(url)
            .apply(options)
            .into(this)

}

/**
 *  加载圆角图(tips:默认radius：0dp)
 */
fun ImageView.loadBorderRoundImage(url: String, radius: Int = 0) {
    val options = RequestOptions().transform(RoundTransformation(MyApplication.getContext(), radius))
    Glide.with(MyApplication.getContext())
            .load(url)
            .apply(options)
            .into(this)

}