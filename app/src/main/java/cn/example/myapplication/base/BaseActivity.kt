package cn.example.myapplication.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

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
        setContentView(getLayout())
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
    }

    override fun showSuccess() {
    }

    override fun showError() {
    }

    override fun showNoNet() {
    }

    override fun onRetry() {
    }
}
