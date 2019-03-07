package cn.example.myapplication

import cn.example.myapplication.base.BaseActivity
import cn.example.myapplication.base.BaseContract

/**
 * @author SunShine-Joex
 * @date   ${DATE}
 * @desc
 */

class MainActivity : BaseActivity<BaseContract.BasePresenter>() {

    override fun getLayout() = R.layout.activity_main


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
}
