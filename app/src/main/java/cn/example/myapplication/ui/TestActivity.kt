package cn.example.myapplication.ui

import android.content.Intent
import android.os.Handler
import android.view.View
import cn.example.myapplication.MainActivity
import cn.example.myapplication.R
import cn.example.myapplication.base.BaseActivity
import cn.example.myapplication.bean.HolidayBean
import cn.example.myapplication.ui.contract.TestContract
import cn.example.myapplication.ui.presenter.TestPresenter
import cn.example.myapplication.utils.toast
import kotlinx.android.synthetic.main.activity_test.*

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc
 */


class TestActivity : BaseActivity<TestPresenter>(), TestContract.View, View.OnClickListener {

    var model: HolidayBean? = null

    override fun createPresenter(): TestPresenter? = TestPresenter()

    override fun getLayout(): Int = R.layout.activity_test

    override fun initView() {
        button2.setOnClickListener(this)
    }

    override fun initData() {
        //发起请求
        mPresenter!!.getData()

    }

    /**    * 数据回调
     *
     */
    override fun loadData(holiday: HolidayBean) {
        model = holiday
        Handler().postDelayed(
                { button2.text = holiday.toString() },
                4000)
    }

    override fun onClick(v: View?) {
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("model", model)
        when (v!!.id) {
            R.id.button2 -> {
                startActivity(intent)
                toast(getString(R.string.app_name))
//                finish()
            }
        /* startActivity<MainActivity>("name" to "sunshine",
                    "age" to 21,
                    "model" to model)*/
        }
    }
}
