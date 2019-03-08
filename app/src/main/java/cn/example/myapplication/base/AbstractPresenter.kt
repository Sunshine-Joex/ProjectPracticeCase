package cn.example.myapplication.base

import cn.example.myapplication.net.ApiService
import cn.example.myapplication.net.RetrofitClient

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc   抽象Presenter
 */
abstract class AbstractPresenter<V : BaseContract.BaseView> : BaseContract.BasePresenter {
    var mApiService: ApiService? = null

    init {
        mApiService = RetrofitClient.createService()
    }

    protected var mView: V? = null

    /**
     * 绑定 view
     */
    override fun attachView(view: BaseContract.BaseView) {
        this.mView = view as V
    }

    /**
     * 解绑 view
     */
    override fun detachView() {
        mView?.let {
            mView = null
        }
    }
}