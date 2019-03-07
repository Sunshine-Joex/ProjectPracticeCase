package cn.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.example.myapplication.base.BaseActivity
import cn.example.myapplication.base.BaseContract

/**
 * @author SunShine-Joex
 * @date   ${DATE}
 * @desc
 */

class MainActivity : BaseActivity<BaseContract.BasePresenter>() {
    override fun getLayout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createPresenter(): BaseContract.BasePresenter? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
}
