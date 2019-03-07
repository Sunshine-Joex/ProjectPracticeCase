package cn.example.myapplication.base

/**
 * @author SunShine-Joex
 * @date   2019/3/6
 * @desc   Presenter和View的契约接口
 */

interface BaseContract {
    interface BasePresenter {

        /**
         * 绑定View
         */
        fun attachView(view: BaseView)

        /**
         * 解除绑定
         */
        fun detachView()
    }

    interface BaseView {
        /**
         * 显示加载页面
         */
        fun showLoading()

        /**
         * 显示内容页面
         */
        fun showSuccess()

        /**
         * 显示错误页面
         */
        fun showError()

        /**
         * 显示无网络页面
         */
        fun showNoNet()

        /**
         * 加载失败重试
         */
        fun onRetry()
    }
}