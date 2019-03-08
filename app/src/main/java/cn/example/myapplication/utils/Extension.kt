package cn.example.myapplication.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.Serializable

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}

fun Activity.toast(msg: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, time).show()

}

fun Fragment.toast(msg: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity, msg, time).show()
}

inline fun <reified T : Activity> Context.startActivity(vararg params: Pair<String, Any>) {
    val intent = Intent(this, T::class.java)
    params.forEach {
        val key = it.first
        val value = it.second
        when (value) {
            null -> intent.putExtra(key, null as Serializable?)
            is Int -> intent.putExtra(key, value)
            is Long -> intent.putExtra(key, value)
            is CharSequence -> intent.putExtra(key, value)
            is String -> intent.putExtra(key, value)
            is Float -> intent.putExtra(key, value)
            is Double -> intent.putExtra(key, value)
            is Char -> intent.putExtra(key, value)
            is Short -> intent.putExtra(key, value)
            is Boolean -> intent.putExtra(key, value)
            is Serializable -> intent.putExtra(key, value)
            is Bundle -> intent.putExtra(key, value)
            is Parcelable -> intent.putExtra(key, value)
            is Array<*> -> when {
                value.isArrayOf<CharSequence>() -> intent.putExtra(key, value)
                value.isArrayOf<String>() -> intent.putExtra(key, value)
                value.isArrayOf<Parcelable>() -> intent.putExtra(key, value)
//                else -> throw AnkoException("Intent extra ${key} has wrong type ${value.javaClass.name}")
            }
            is IntArray -> intent.putExtra(key, value)
            is LongArray -> intent.putExtra(key, value)
            is FloatArray -> intent.putExtra(key, value)
            is DoubleArray -> intent.putExtra(key, value)
            is CharArray -> intent.putExtra(key, value)
            is ShortArray -> intent.putExtra(key, value)
            is BooleanArray -> intent.putExtra(key, value)
//            else -> throw AnkoException("Intent extra ${key} has wrong type ${value.javaClass.name}")
        }
        return@forEach
    }
    startActivity(intent)

}