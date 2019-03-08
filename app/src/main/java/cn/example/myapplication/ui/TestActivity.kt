package cn.example.myapplication.ui

import android.os.Handler
import cn.example.myapplication.R
import cn.example.myapplication.base.BaseActivity
import cn.example.myapplication.ui.contract.TestContract
import cn.example.myapplication.ui.presenter.TestPresenter
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : BaseActivity<TestPresenter>(), TestContract.View {


    override fun createPresenter(): TestPresenter? {
        return TestPresenter()
    }

    override fun getLayout(): Int = R.layout.activity_test

    override fun onResume() {
        super.onResume()
        //发起请求
        mPresenter!!.getData()
    }

    /**
     * 数据回调
     *
     */
    override fun loadData() {
        Handler().postDelayed(
                { button2.text = "100" },
                2000)
    }
}
