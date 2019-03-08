package cn.example.myapplication.base

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
abstract class AbstractPresenter<V : BaseContract.BaseView> : BaseContract.BasePresenter {

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