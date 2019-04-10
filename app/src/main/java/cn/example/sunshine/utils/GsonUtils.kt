package cn.example.sunshine.utils

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.JsonParser


/**
 * @author SunShine-Joex
 * @date   2019/3/15
 * @desc   Gson 封装的json解析工具
 */
fun <T> toJsonObject(jsonString: String, t: Class<T>): T {
    if (TextUtils.isEmpty(jsonString)) {
        throw Exception("jsonString not is null!")
    } else {
        return Gson().fromJson<T>(jsonString, t)
    }
}

/**
 *  此方法会报错：
 *  报错原因：泛型在编译期类型被擦除导致报错
 *  报错信息：com.google.gson.internal.LinkedTreeMap cannot be cast to Class
 */
fun <T> toJsonArray(jsonString: String, cls: Class<T>): List<T> {
    return Gson().fromJson(jsonString, object : TypeToken<List<T>>() {}.type)
}

fun <T> toJsonList(json: String, clazz: Class<T>): List<T> {
    if (TextUtils.isEmpty(json)) {
        throw Exception("jsonString not is null!")
    } else {
        var list = mutableListOf<T>()
        val array = JsonParser().parse(json).asJsonArray
        array.forEach {
            list.add(Gson().fromJson(it, clazz))
        }
        return list
    }

}