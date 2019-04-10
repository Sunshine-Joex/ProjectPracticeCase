package cn.example.sunshine.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.example.sunshine.R
import cn.example.sunshine.utils.StatusBarLightMode
import cn.example.sunshine.widget.MultiStateView
import cn.example.sunshine.widget.SimpleMultiStateView
import kotlinx.android.synthetic.main.activity_test.*

/**
 * @author SunShine-Joex
 * @date   2019/3/6
 * @desc   Activity基类
 */

abstract class BaseActivity<P : BaseContract.BasePresenter> : AppCompatActivity(), BaseContract.BaseView {

    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        if (mPresenter != null) {
            mPresenter!!.attachView(this)
        }
        if (setStatusBarBlack()) {
            StatusBarLightMode(window)
        }
        setContentView(getLayout())
        initStateView()
        initView()
        initData()
    }

    open fun setStatusBarBlack() = false

    private fun initStateView() {
        if (simpleMultiStateView == null) {
            return
        }
        simpleMultiStateView!!.setEmptyResource(R.layout.view_empty)
                .setRetryResource(R.layout.view_retry)
                .setLoadingResource(R.layout.view_loading)
                .setNoNetResource(R.layout.view_nonet)
                .build()
                .setOnReLoadListener(object : MultiStateView.onReLoadListener {
                    override fun onReload() {
                        onRetry()
                    }

                })
    }

    protected fun getStateView(): SimpleMultiStateView? {
        return simpleMultiStateView
    }

    open fun initData() {

    }

    open fun initView() {

    }

    abstract fun getLayout(): Int

    open fun createPresenter(): P? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) {
            mPresenter!!.detachView()
        }
    }

    override fun showLoading() {
        if (simpleMultiStateView != null) {
            simpleMultiStateView!!.showLoadingView()
        }
    }

    override fun showSuccess() {
        if (simpleMultiStateView != null) {
            simpleMultiStateView!!.showContent()
        }
    }

    override fun showError() {
        if (simpleMultiStateView != null) {
            simpleMultiStateView!!.showErrorView()
        }
    }

    override fun showNoNet() {
        if (simpleMultiStateView != null) {
            simpleMultiStateView!!.showNoNetView()
        }
    }

    override fun onRetry() {
        showLoading()
        initData()
    }
}
