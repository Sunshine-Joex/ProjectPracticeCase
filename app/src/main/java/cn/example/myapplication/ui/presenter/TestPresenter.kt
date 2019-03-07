package cn.example.myapplication.ui.presenter

import cn.example.myapplication.base.BaseContract
import cn.example.myapplication.ui.contract.TestContract

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc
 */
class TestPresenter  : BaseContract.BasePresenter<TestContract.View>(), TestContract.Presenter {
    override fun attachView(view: BaseContract.BaseView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}