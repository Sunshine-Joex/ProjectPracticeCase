package cn.example.sunshine.utils

import android.content.res.Resources
import android.graphics.*
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest

/**
 * @author SunShine-Joex
 * @date   2019/4/10
 * @desc
 */
class RoundTransformation : BitmapTransformation {
    private var mRadius = 0f


    constructor(radius: Int) {
        mRadius = Resources.getSystem().displayMetrics.density * radius
    }


    override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap? {
        return roundCrop(pool, toTransform)
    }

    private fun roundCrop(pool: BitmapPool, toTransform: Bitmap?): Bitmap? {
        if (toTransform == null) {
            return null
        }

        var result: Bitmap? = pool.get(toTransform.width, toTransform.height, Bitmap.Config.ARGB_8888)
        if (result == null) {
            result = Bitmap.createBitmap(toTransform.width, toTransform.height, Bitmap.Config.ARGB_8888)
        }

        val canvas = Canvas(result!!)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.shader = BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.isAntiAlias = true
        val rectF = RectF(0f, 0f, toTransform.width.toFloat(), toTransform.height.toFloat())
        canvas.drawRoundRect(rectF, mRadius, mRadius, paint)
        return result
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {

    }
}