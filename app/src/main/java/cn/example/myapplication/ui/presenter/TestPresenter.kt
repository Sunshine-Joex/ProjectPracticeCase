package cn.example.myapplication.ui.presenter

import cn.example.myapplication.base.AbstractPresenter
import cn.example.myapplication.base.BaseContract
import cn.example.myapplication.bean.HolidayBean
import cn.example.myapplication.net.BaseObserver
import cn.example.myapplication.ui.contract.TestContract
import cn.example.myapplication.extension.applySchedulers

/**
 * @author SunShine-Joex
 * @date   2019/3/7
 * @desc   test Presenter
 */
class TestPresenter : AbstractPresenter<TestContract.View>(), TestContract.Presenter {

    override fun getData() {
        mView!!.showLoading()
        mApiService!!.getHoliday("20190308")
                .applySchedulers()
                .subscribe(object : BaseObserver<HolidayBean, BaseContract.BaseView>(mView!!) {
                    override fun onSuccess(t: HolidayBean?) {
                        super.onSuccess(t)
                        mView!!.loadData(t!!)
                    }
//                    override fun onSuccess(t: HolidayBean?) {
//                        mView!!.loadData(t!!)
//                    }


                })

    }

}