package cn.example.myapplication.bean

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author SunShine-Joex
 * @date   2019/3/8
 * @desc
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class HolidayBean(
        val avoid: String,
        val chineseZodiac: String,
        val date: String,
        val dayOfYear: Int,
        val lunarCalendar: String,
        val solarTerms: String,
        val suit: String,
        val type: Int,
        val typeDes: String,
        val weekDay: Int,
        val weekOfYear: Int,
        val yearTips: String
) : Parcelable