package cn.example.myapplication

import cn.example.myapplication.base.BaseActivity
import cn.example.myapplication.base.BaseContract
import cn.example.myapplication.bean.HolidayBean
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc
 */

class MainActivity : BaseActivity<BaseContract.BasePresenter>() {

    var mHolidayBean: String? = null

    override fun getLayout() = R.layout.activity_main


    override fun onResume() {
        super.onResume()
        mHolidayBean = intent.getStringExtra("name")
        textView.text = mHolidayBean
    }
}
