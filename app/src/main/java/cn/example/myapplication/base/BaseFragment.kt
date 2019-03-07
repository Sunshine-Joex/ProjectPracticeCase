package cn.example.myapplication.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author SunShine-Joex
 * @date   2019/3/6
 * @desc   Fragment基类
 */

abstract class BaseFragment<P : BaseContract.BasePresenter> : Fragment(), BaseContract.BaseView {

    private var mRootView: View? = null
    private var mContext: Context? = null
    private var mPresenter: P? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = inflater!!.inflate(getLayout(), container, false)
        } else {
            val parent = mRootView!!.parent as ViewGroup
            parent.removeView(mRootView)
        }
        mContext = mRootView!!.context
        mPresenter = createPresenter()
        if (mPresenter != null) {
            mPresenter!!.attachView(this)
        }
        return mRootView
    }

    abstract fun createPresenter(): P?

    abstract fun getLayout(): Int

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