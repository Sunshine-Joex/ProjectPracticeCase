package cn.example.myapplication

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
class MyApplication : Application() {

    companion object {
        private var instance: Application? = null
        private var mCurrentActivity: Activity? = null
        private var mContext: Context? = null

        fun instance() = instance!!
        fun getCurrentActivity() = mCurrentActivity!!
        fun getContext() = mContext!!
    }


//var mFrontActivityList: MutableList<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        mContext = applicationContext
        initActivityManager()


    }

    private fun initActivityManager() {
//        mFrontActivityList = mutableListOf()
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
                mCurrentActivity = activity
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
//                mFrontActivityList!!.add(activity!!)
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            }

        })
    }


}