package cn.example.myapplication.ui.contract

import cn.example.myapplication.base.BaseContract

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc
 */
interface TestContract {
    interface View : BaseContract.BaseView {

        fun loadData()

    }

    interface Presenter : BaseContract.BasePresenter {

        fun getData()

    }
}