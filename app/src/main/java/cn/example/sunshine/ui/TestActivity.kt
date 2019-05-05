package cn.example.sunshine.ui

import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cn.example.sunshine.MainActivity
import cn.example.sunshine.MyApplication
import cn.example.sunshine.R
import cn.example.sunshine.base.BaseActivity
import cn.example.sunshine.bean.HolidayBean
import cn.example.sunshine.bean.User
import cn.example.sunshine.extension.*
import cn.example.sunshine.ui.contract.TestContract
import cn.example.sunshine.ui.presenter.TestPresenter
import cn.example.sunshine.utils.SharedPreferences
import cn.example.sunshine.utils.toJsonArray
import cn.example.sunshine.widget.popupwindow.EasyPopup
import cn.example.sunshine.widget.popupwindow.XGravity
import cn.example.sunshine.widget.popupwindow.YGravity
import kotlinx.android.synthetic.main.activity_test.*

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc
 */

const val url: String = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/" +
        "timg?image&quality=100&size=b4000_4000&sec=1552546967&di=b5b32debb2f17f753546495f455d8b85&src=http:" +
        "//b-ssl.duitang.com/uploads/item/201411/02/20141102234940_mAydx.jpeg"

class TestActivity : BaseActivity<TestPresenter>(), TestContract.View, View.OnClickListener {

    var mPop: EasyPopup? = null

    var isLogin: Boolean by SharedPreferences.preference(this, "islogin", false)
    var model: HolidayBean? = null

    override fun createPresenter(): TestPresenter? = TestPresenter()

    override fun getLayout(): Int = R.layout.activity_test

    override fun initView() {
        mData.setOnClickListener(this)
        mLoginOut.setOnClickListener(this)
        testRoundImg.setOnClickListener(this)
        supportActionBar!!.title = isLogin.toString()
    }

    override fun initData() {
        //发起请求
        mPresenter!!.getData()
        testRoundImg.loadBorderRoundImage(url, dp2px(2.0f))
    }

    /** 数据回调
     *
     */
    override fun loadData(holiday: HolidayBean) {
        model = holiday
        Handler().postDelayed(
                { mData.text = holiday.toString() },
                0)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mData -> {
                toast(getString(R.string.app_name))
                startActivity<MainActivity>("name" to "sunshine",
                        "age" to 21)
            }
            R.id.mLoginOut -> {
                for (activity in MyApplication.getActivitys()) {
                    activity.finish()
                }
            }
            R.id.testRoundImg -> {
                initPop()
            }


        }
    }


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun initPop() {
        var tv = TextView(this)
        tv.setBackgroundColor(Color.CYAN)
        tv.text = "EasyPopup"
        mPop = EasyPopup.create()
                .setContext(this)
                .setContentView(tv)
                .setOnViewListener { view, popup -> }
                .setFocusAndOutsideEnable(true)
                .setHeight(dp2px(500f))
                .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .apply()
//        mPop?.showAsDropDown(testRoundImg,Gravity.CENTER_HORIZONTAL,0,0)
        mPop!!.showAtLocation(testRoundImg,Gravity.CENTER_HORIZONTAL,0,0)
//        mPop!!.showAtAnchorView(testRoundImg, YGravity.ABOVE, XGravity.CENTER, 0, -dp2px(10f))

    }

}
