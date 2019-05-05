package cn.example.sunshine

import android.view.View
import cn.example.sunshine.base.BaseActivity
import cn.example.sunshine.base.BaseContract
import cn.example.sunshine.extension.startActivity
import cn.example.sunshine.ui.TestActivity
import cn.example.sunshine.utils.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc
 */


class MainActivity : BaseActivity<BaseContract.BasePresenter>(), View.OnClickListener {

    var isLogin: Boolean by SharedPreferences.preference(this, "islogin", false)

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
        super.initView()
    }

    override fun onResume() {
        super.onResume()
        testNetView.setOnClickListener(this)
        imageTopStatusBar.setOnClickListener(this)
        isLogin = true
/*
        percentview.coinName="BTC"
        percentview.precentMax=80
        percentview.sweepAngleMax=288f
        percentview.setProgressNum(2000)*/


    }


    override fun setStatusBarBlack(): Boolean {
        return true
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.testNetView -> startActivity<TestActivity>()
            R.id.imageTopStatusBar -> startActivity<ImageTopActivity>()

        }
    }


}
