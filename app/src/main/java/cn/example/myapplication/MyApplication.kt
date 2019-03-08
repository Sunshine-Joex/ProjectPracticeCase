package cn.example.myapplication

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
class MyApplication : Application() {

    private var mCurrentActivity: Activity? = null
//var mFrontActivityList: MutableList<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        initActivityManager()
    }

    private fun initActivityManager() {
//        mFrontActivityList = mutableListOf()
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {

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
                mCurrentActivity = activity
//                mFrontActivityList!!.add(activity!!)
            }

        })
    }

    companion object {

        fun getCurrentActivity(): Activity {
            return MyApplication().mCurrentActivity!!
        }
    }
}