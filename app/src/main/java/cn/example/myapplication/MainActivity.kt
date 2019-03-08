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

    var mHolidayBean: HolidayBean? = null

    override fun getLayout() = R.layout.activity_main


    override fun onResume() {
        super.onResume()
        mHolidayBean = intent.getParcelableExtra("model")
        textView.text = mHolidayBean!!.weekDay.toString()
    }
}
