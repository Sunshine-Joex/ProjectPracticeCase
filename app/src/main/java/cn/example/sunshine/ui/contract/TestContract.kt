package cn.example.sunshine.ui.contract

import cn.example.sunshine.base.BaseContract
import cn.example.sunshine.bean.HolidayBean

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc   test 契约接口
 */
interface TestContract {
    interface View : BaseContract.BaseView {

        fun loadData(holiday: HolidayBean)

    }

    interface Presenter : BaseContract.BasePresenter {

        fun getData()

    }
}