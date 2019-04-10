package cn.example.sunshine.bean

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
data class HttpResponseBean<T>(
        val code: Int,
        val data: T,
        val msg: String
)
