package cn.example.myapplication.net

import cn.example.myapplication.bean.HolidayBean
import cn.example.myapplication.bean.HttpResponseBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc   api service
 */
interface ApiService {

    @GET("holiday/single1/{date}")
    fun getHoliday(@Path("date") date: String): Observable<HttpResponseBean<HolidayBean>>

}