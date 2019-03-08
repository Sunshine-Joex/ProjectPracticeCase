package cn.example.myapplication.net

import cn.example.myapplication.bean.HttpResponseBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
abstract class BaseObserver<T> : Observer<HttpResponseBean<T>> {

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

    abstract fun onSuccess(t: T?)

    abstract fun onFailure(e: Throwable)

}