package cn.example.sunshine.utils

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author SunShine-Joex
 * @date   2019/3/15
 * @desc
 */
fun <T> toJsonObject(jsonString: String, t: Class<T>): T {
    if (TextUtils.isEmpty(jsonString)) {
        throw Exception("jsonString not is null!")
    } else {
        return Gson().fromJson<T>(jsonString, t)
    }
}

fun <T> toJsonArray(jsonString: String, cls: Class<T>): List<T> {
    return Gson().fromJson(jsonString, object : TypeToken<List<T>>() {}.type)
}