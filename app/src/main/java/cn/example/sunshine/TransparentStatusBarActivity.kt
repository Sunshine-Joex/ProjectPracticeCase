package cn.example.sunshine

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import cn.example.sunshine.base.BaseActivity
import cn.example.sunshine.base.BaseContract
import kotlinx.android.synthetic.main.activity_image_top.*
import android.view.View
import android.widget.ImageView
import cn.example.sunshine.extension.loadBorderRoundImage
import cn.example.sunshine.utils.setNavigationBarColor
import cn.example.sunshine.utils.transparentStatusBar
import com.zhouwei.mzbanner.MZBannerView
import com.zhouwei.mzbanner.holder.MZViewHolder


const val url: String = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/" +
        "timg?image&quality=100&size=b4000_4000&sec=1552546967&di=b5b32debb2f17f753546495f455d8b85&src=http:" +
        "//b-ssl.duitang.com/uploads/item/201411/02/20141102234940_mAydx.jpeg"

class ImageTopActivity : BaseActivity<BaseContract.BasePresenter>() {
    override fun getLayout(): Int = R.layout.activity_image_top
    var list = listOfNotNull(url, url, url)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        transparentStatusBar(this)
        setNavigationBarColor(this, Color.GRAY)
    }

    override fun initView() {
        super.initView()
        (banner as MZBannerView<Any>)?.setPages(list, { BannerViewHolder() })
        banner.start()
    }


    class BannerViewHolder : MZViewHolder<String> {
        private var mImageView: ImageView? = null

        override fun createView(context: Context): View {
            // 返回页面布局
//            val view = LayoutInflater.from(context).inflate(R.layout.banner_item, null)
            mImageView = ImageView(context)
            mImageView!!.scaleType = ImageView.ScaleType.FIT_XY
            return mImageView!!
        }

        override fun onBind(context: Context, position: Int, data: String?) {
            mImageView!!.loadBorderRoundImage(data!!)
        }
    }

}
