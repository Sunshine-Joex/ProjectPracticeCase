package cn.example.myapplication.net

import cn.example.myapplication.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
object RetrofitClient {
    var mRetrofit: Retrofit? = null
    var mOkHttpClient: OkHttpClient? = null
    var mApiService: ApiService? = null
    const val CONNECTTIMEOUT = 10L

    init {
        mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(CONNECTTIMEOUT, TimeUnit.SECONDS)
                .readTimeout(CONNECTTIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(addheader())//log、统一header配置
                .build()

        mRetrofit = Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl("http://www.mxnzp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun createService(): ApiService {
        return if (mApiService == null)
            mRetrofit!!.create(ApiService::class.java)
        else mApiService!!
    }

//    fun <T> createService(service: Class<T>): T {
//        if (service == null) {
//            throw RuntimeException("Api service is null!")
//        }
//        return mRetrofit!!.create(service)
//    }

    //添加头信息
    fun addheader(): Interceptor {
        val interceptor = Interceptor { chain ->
            val request = chain?.request()?.newBuilder()?.addHeader("key", "value")?.build()
            chain?.proceed(request)
        }
        return interceptor
    }


}