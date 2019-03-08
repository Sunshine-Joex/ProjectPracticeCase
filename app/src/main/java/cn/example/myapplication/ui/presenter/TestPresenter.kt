package cn.example.myapplication.ui.presenter

import cn.example.myapplication.base.AbstractPresenter
import cn.example.myapplication.ui.contract.TestContract

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc
 */
class TestPresenter  : AbstractPresenter<TestContract.View>(), TestContract.Presenter {

    override fun getData() {
          mView!!.loadData()
    }

}