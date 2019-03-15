package cn.example.myapplication.ui

import android.graphics.Color
import android.os.Handler
import android.view.View
import cn.example.myapplication.MainActivity
import cn.example.myapplication.MyApplication
import cn.example.myapplication.R
import cn.example.myapplication.base.BaseActivity
import cn.example.myapplication.bean.HolidayBean
import cn.example.myapplication.extension.*
import cn.example.myapplication.ui.contract.TestContract
import cn.example.myapplication.ui.presenter.TestPresenter
import cn.example.myapplication.utils.SharedPreferences
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

    var isLogin: Boolean by SharedPreferences.preference(this, "islogin", false)
    var model: HolidayBean? = null

    override fun createPresenter(): TestPresenter? = TestPresenter()

    override fun getLayout(): Int = R.layout.activity_test

    override fun initView() {
        mData.setOnClickListener(this)
        mLoginOut.setOnClickListener(this)
        supportActionBar!!.title = isLogin.toString()


    }

    override fun initData() {
        //发起请求
        mPresenter!!.getData()
        testImg.loadBorderCircleImage(url)
        testBorderImg.loadBorderCircleImage(url, dp2px(1.0f).toFloat(), Color.CYAN)
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

        }
    }

}
