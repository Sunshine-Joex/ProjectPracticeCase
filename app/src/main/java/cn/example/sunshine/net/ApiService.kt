package cn.example.sunshine.net

import cn.example.sunshine.bean.HolidayBean
import cn.example.sunshine.bean.HttpResponseBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc   api service
 */
interface ApiService {

    @GET("holiday/single/{date}")
    fun getHoliday(@Path("date") date: String): Observable<HttpResponseBean<HolidayBean>>

}