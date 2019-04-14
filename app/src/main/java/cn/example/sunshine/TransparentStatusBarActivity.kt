package cn.example.sunshine

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import cn.example.sunshine.base.BaseActivity
import cn.example.sunshine.base.BaseContract
import kotlinx.android.synthetic.main.activity_image_top.*
import android.view.View
import android.widget.ImageView
import cn.example.sunshine.extension.loadBorderRoundImage
import cn.example.sunshine.utils.setNavigationBarColor
import cn.example.sunshine.utils.transparentStatusBar
import cn.example.sunshine.widget.ArcSeekBar
import cn.example.sunshine.widget.CircleSeekBar
import com.zhouwei.mzbanner.MZBannerView
import com.zhouwei.mzbanner.holder.MZViewHolder


const val url: String = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/" +
        "timg?image&quality=100&size=b4000_4000&sec=1552546967&di=b5b32debb2f17f753546495f455d8b85&src=http:" +
        "//b-ssl.duitang.com/uploads/item/201411/02/20141102234940_mAydx.jpeg"


class ImageTopActivity : BaseActivity<BaseContract.BasePresenter>(), ArcSeekBar.OnProgressChangeListener, View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.close -> {
                arc_seek_bar.setOnTouchListener { v, event -> true }
                arc_seek_bar.setVisible(false)
            }
            R.id.start -> {
                arc_seek_bar.setOnTouchListener { v, event -> false }
                arc_seek_bar.setVisible(true)

            }
        }
    }

    override fun onProgressChanged(seekBar: ArcSeekBar?, progress: Int, isUser: Boolean) {


        money.text = (50000 - progress * 1000).toString()
//progress 49 0  48 1 47 2
        Log.e("progress:","$progress -> ${Math.abs(progress-49)}")

        circularFillableLoaders.setProgress((progress+1)*2)

    }

    override fun onStartTrackingTouch(seekBar: ArcSeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: ArcSeekBar?) {

    }


    override fun getLayout(): Int = R.layout.activity_image_top
    var list = listOfNotNull(url, url, url)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        supportActionBar!!.hide()
//        transparentStatusBar(this)
        setNavigationBarColor(this, Color.GRAY)
    }

    override fun initView() {
        super.initView()
        (banner as MZBannerView<Any>)?.setPages(list, { BannerViewHolder() })
        banner.start()
        initBroadCast()
        arc_seek_bar.setOnProgressChangeListener(this)
        close.setOnClickListener(this)
        start.setOnClickListener(this)
    }


    class BannerViewHolder : MZViewHolder<String> {
        private var image: ImageView? = null

        override fun createView(context: Context): View {
// 返回页面布局
            val view = LayoutInflater.from(context).inflate(R.layout.banner_item, null)
            image = view.findViewById<ImageView>(R.id.banner_image)

//            mImageView = ImageView(context)
            image!!.scaleType = ImageView.ScaleType.FIT_XY
            return view!!
        }

        override fun onBind(context: Context, position: Int, data: String?) {
            image!!.loadBorderRoundImage(data!!)
        }
    }

    private fun initBroadCast() {
        var notices = ArrayList<String>()
        notices.add("套马的汉子你威武雄壮 ")
        notices.add("飞驰的骏马像疾风一样 ")
        notices.add("一望无际的原野随你去流浪 ")
        notices.add("你的心海和大地一样宽广 ")
        marqueeview.startMarquee(notices)

    }

}
