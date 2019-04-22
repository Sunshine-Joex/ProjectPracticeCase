package cn.example.sunshine.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import cn.example.sunshine.R
import cn.example.sunshine.extension.sp2px

/**
 * @author SunShine-Joex
 * @date   2019/4/19
 * @desc    一个带动画的进度百分比view
 */
class PercentageView(context: Context, attrs: AttributeSet, defStyleAttr: Int) : View(context, attrs, defStyleAttr) {
    private var rPaint: Paint? = null//矩形的画笔
    private var progressPaint: Paint? = null//圆弧的画笔
    private var mTextBottomPaint: Paint? = null//进度画笔
    private var mTextTopPaint: Paint? = null//中上文字

    var coinName: String? = null//coin名字
    var coinNameSize: Float = 0.0f
    var precent = 0//更新百分比
    var sweepAngle: Float = 0.toFloat()//圆弧经过的角度

    var precentMax: Int = 0//带有动画最大百分比
    var sweepAngleMax: Float = 0.toFloat()//带有动画最大弧度

    internal var anim: CircleAnim//内部动画

    init {
        initAttrs(context, attrs, defStyleAttr)
        init()
        anim = CircleAnim()
    }

    private fun initAttrs(context: Context, attrs: AttributeSet, defStyleAttr: Int) {
        var array = context.obtainStyledAttributes(attrs, R.styleable.PercentageView, defStyleAttr, 0)
        coinName = array.getString(R.styleable.PercentageView_per_coin_text)
        coinNameSize = array.getDimension(R.styleable.PercentageView_per_coin_size, sp2px(10).toFloat())
        array.recycle()


    }

    private fun init() {
        rPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        rPaint!!.style = Paint.Style.STROKE//不填充
        rPaint!!.color = Color.parseColor("#E6E6E6")
        rPaint!!.strokeWidth = dp2px(15).toFloat()

        progressPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        progressPaint!!.strokeCap = Paint.Cap.ROUND
        progressPaint!!.style = Paint.Style.STROKE//不填充
        progressPaint!!.color = Color.parseColor("#FF5A2E")
        progressPaint!!.strokeWidth = dp2px(15).toFloat()

        mTextBottomPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mTextBottomPaint!!.style = Paint.Style.STROKE
        mTextBottomPaint!!.color = Color.parseColor("#FF5A2E")
        //        mTextBottomPaint.setFakeBoldText(true);//设置粗体
        mTextBottomPaint!!.textSize = sp2px(24).toFloat()
        mTextBottomPaint!!.textAlign = Paint.Align.CENTER

        mTextTopPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mTextTopPaint!!.style = Paint.Style.STROKE
        mTextTopPaint!!.color = Color.parseColor("#4E5463")
        //        mTextTopPaint.setFakeBoldText(true);//设置粗体
        mTextTopPaint!!.textSize = sp2px(14).toFloat()
        mTextTopPaint!!.textAlign = Paint.Align.CENTER


    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val min = Math.min(width, height)
        val center = min / 2 // 获取圆心的x坐标
        val radius = center - dp2px(15) / 2// 半径
        val rectF = RectF((center - radius).toFloat(), (center - radius).toFloat(), (center + radius).toFloat(), (center + radius).toFloat())
        canvas.drawArc(rectF, 0f, 360f, false, rPaint!!)
        canvas.drawArc(rectF, 0f, sweepAngle, false, progressPaint!!)//这里角度0对应的是三点钟方向，顺时针方向递增
        canvas.drawText(precent.toString() + "%", center.toFloat(),
                center - (mTextBottomPaint!!.descent() + mTextBottomPaint!!.ascent()) / 2 + dp2px(15), mTextBottomPaint!!)
        canvas.drawText(coinName!!, center.toFloat(),
                center - (mTextTopPaint!!.descent() + mTextTopPaint!!.ascent()) / 2 - dp2px(15), mTextTopPaint!!)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var measurewidth = 400
        var measureheight = 400
        measurewidth = View.resolveSize(measurewidth, widthMeasureSpec)
        measureheight = View.resolveSize(measureheight, heightMeasureSpec)
        setMeasuredDimension(measurewidth, measureheight)

    }

    inner class CircleAnim : Animation() {

        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            super.applyTransformation(interpolatedTime, t)
            sweepAngle = interpolatedTime * sweepAngleMax
            precent = (interpolatedTime * precentMax).toInt()
            invalidate()

        }
    }


    //设置动画时间
    fun setProgressNum(time: Int) {
        anim.duration = time.toLong()
        this.startAnimation(anim)
    }

    /**
     * convert dp to its equivalent px
     */
    protected fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()
    }

    /**
     * convert sp to its equivalent px
     */
    protected fun sp2px(sp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp.toFloat(), resources.displayMetrics).toInt()
    }


}
