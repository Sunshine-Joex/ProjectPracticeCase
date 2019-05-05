package cn.example.sunshine.ui.presenter

import cn.example.sunshine.base.AbstractPresenter
import cn.example.sunshine.base.BaseContract
import cn.example.sunshine.bean.HolidayBean
import cn.example.sunshine.net.BaseObserver
import cn.example.sunshine.ui.contract.TestContract
import cn.example.sunshine.extension.applySchedulers

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc   test Presenter
 */
class TestPresenter : AbstractPresenter<TestContract.View>(), TestContract.Presenter {

    override fun getData() {
//        mView!!.showLoading()
        mApiService!!.getHoliday("20190308")
                .applySchedulers()
                .subscribe(object : BaseObserver<HolidayBean, BaseContract.BaseView>(mView!!) {
                    override fun onSuccess(t: HolidayBean?) {
                        super.onSuccess(t)
                        mView!!.loadData(t!!)
                        mView!!.showEmpty()
                    }
//                    override fun onSuccess(t: HolidayBean?) {
//                        mView!!.loadData(t!!)
//                    }


                })

    }

}