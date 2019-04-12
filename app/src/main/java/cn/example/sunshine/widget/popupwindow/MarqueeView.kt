package cn.example.sunshine.widget.popupwindow

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.ViewFlipper
import cn.example.sunshine.R
import cn.example.sunshine.extension.sp2px

/**
 * @author SunShine-Joex
 * @date   2019/4/12
 * @desc
 */
class MarqueeView : ViewFlipper{
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        init(attrs)
    }


    /**
     * 滚动间隔时间
     */
    private var mvInterval: Int = 0
    /**
     * 动画持续时间
     */
    private var mvAnimDuration: Int = 0
    /**
     * 文字大小
     */
    private var mvTextSize: Int = 0
    /**
     * 文字颜色
     */
    private var mvTextColor: Int = 0
//    private var context: Context? = null
    /**
     * 当前消息位置
     */
    private var position: Int = 0
    /**
     * 动画是否开始,防止
     */
    private var isAnimStarted: Boolean = false


    private fun init(attrs: AttributeSet?) {
        val typedArray =context.obtainStyledAttributes(attrs, R.styleable.MarqueeViewStyle)
        mvInterval = typedArray.getInteger(R.styleable.MarqueeViewStyle_mvInterval, mvInterval)
        mvAnimDuration = typedArray.getInteger(R.styleable.MarqueeViewStyle_mvAnimDuration, mvAnimDuration)
        mvTextSize = typedArray.getDimension(R.styleable.MarqueeViewStyle_mvTextSize, mvTextSize.toFloat()).toInt()
        mvTextColor = typedArray.getColor(R.styleable.MarqueeViewStyle_mvTextColor, mvTextColor)
        typedArray.recycle()
        setFlipInterval(mvInterval)
    }

    /**
     *
     * @param notices 滚动的消息列表
     */
    fun startMarquee(notices: List<Any>?) {
        if (notices != null && notices.size > 0) {
            //开启滚动,耗时异步处理
            post {
                //避免重影
                removeAllViews()
                clearAnimation()
                position = 0
                addView(createTextView(position, notices))
                setInAndOutAnimation()
                startFlipping()
                if (inAnimation != null) {
                    inAnimation.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation) {
                            if (isAnimStarted) {
                                animation.cancel()
                            }
                            isAnimStarted = true
                        }

                        override fun onAnimationEnd(animation: Animation) {
                            position++
                            if (position >= notices.size) {
                                position = 0
                            }
                            val view = createTextView(position, notices)
                            if (view.parent == null) {
                                addView(view)
                            }
                            isAnimStarted = false
                        }

                        override fun onAnimationRepeat(animation: Animation) {}
                    })
                }
            }
        }
    }

    /**
     *
     * @param pos 消息的当前位置
     * @param notices 消息列表
     * @return 创建textview
     */
    private fun createTextView(pos: Int, notices: List<Any>?): TextView {
        val textView = TextView(context)
        textView.text = notices!![pos].toString()
        textView.textSize = sp2px(mvTextSize.toFloat()).toFloat()
        textView.setTextColor(mvTextColor)
        textView.gravity = Gravity.CENTER_VERTICAL
        return textView
    }

    /**
     * 设置进入动画和离开动画
     */
    private fun setInAndOutAnimation() {
        val inAnim = AnimationUtils.loadAnimation(context, R.anim.broadcast_anim_bottom_into)
        inAnim.duration = mvAnimDuration.toLong()
        inAnimation = inAnim

        val outAnim = AnimationUtils.loadAnimation(context, R.anim.broadcast_anim_top_out)
        outAnim.duration = mvAnimDuration.toLong()
        outAnimation = outAnim
    }
}
