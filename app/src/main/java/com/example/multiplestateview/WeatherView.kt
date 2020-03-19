package com.example.multiplestateview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.weather_view.view.*


/**
 * @author Huangming  2020/3/8
 */
class WeatherView : LinearLayout {
    private val STATE_SUNNY = intArrayOf(R.attr.state_sunny)
    private val STATE_CLOUDY = intArrayOf(R.attr.state_cloudy)
    private val STATE_RAINING = intArrayOf(R.attr.state_raining)

    private var mWeather: Weather = Weather.RAINING

    constructor(context: Context?) : super(context){
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        Log.d("WeatherView", "构造函数1")
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        Log.d("WeatherView", "构造函数2")
        initView()
    }

    private fun initView() {
        inflate(context, R.layout.weather_view, this)
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray? {
        Log.d("WeatherView", "onCreateDrawableState...")
        // 注意，这里要给数组添加一个容量，用于储存自定义的状态
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        when (mWeather) {
            Weather.SUNNY -> {
                mergeDrawableStates(drawableState, STATE_SUNNY)
            }
            Weather.RAINING -> {
                mergeDrawableStates(drawableState, STATE_RAINING)
            }
            Weather.CLOUDY -> {
                mergeDrawableStates(drawableState, STATE_CLOUDY)
            }
        }
        Log.d("WeatherView", mWeather.name)
        return drawableState
    }

    fun getWeather(): Weather {
        return mWeather
    }

    fun setWeather(weather: Weather) {
        Log.d("WeatherView", "setWeather...")
        if (mWeather!=weather) {
            mWeather = weather
            // 刷新状态
            refreshDrawableState()

            // 根据状态改一下文字
            when (mWeather) {
                Weather.SUNNY -> {
                    tv.text="天晴"
                }
                Weather.RAINING -> {
                    tv.text="下雨"
                }
                Weather.CLOUDY -> {
                    tv.text="多云"
                }
            }
        }
    }
}