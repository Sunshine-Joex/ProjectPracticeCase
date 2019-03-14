package cn.example.myapplication.net

import cn.example.myapplication.base.BaseContract
import cn.example.myapplication.bean.HttpResponseBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
abstract class BaseObserver<T, V : BaseContract.BaseView> : Observer<HttpResponseBean<T>> {

    var v: V? = null

    constructor(v: V) {
        this.v = v
    }

    override fun onError(e: Throwable) {
        onFailure(e)

    }

    override fun onNext(t: HttpResponseBean<T>) {
        onSuccess(t.data)
    }

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    open fun onSuccess(t: T?) {
        v!!.showSuccess()
    }

    open fun onFailure(e: Throwable) {
        if (e is UnknownHostException) {
            v!!.showNoNet()
        } else if (e is SocketTimeoutException ||
                e is ConnectException) {
            v!!.showError()
        }
    }

}