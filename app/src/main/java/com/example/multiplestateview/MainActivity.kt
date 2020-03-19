package com.example.multiplestateview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
var b = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)

        textView.setOnClickListener {
            when (weatherView.getWeather()){
                Weather.SUNNY->{
                    weatherView.setWeather(Weather.CLOUDY)
                }
                Weather.CLOUDY->{
                    weatherView.setWeather(Weather.RAINING)
                }
                Weather.RAINING->{
                    weatherView.setWeather(Weather.SUNNY)
                }
            }
//            aaa.setMessageUnread(b)
//            b=!b

//            startActivity(Intent(this,HomeActivity::class.java))
        }
//        weatherView.setWeather(Weather.RAINING)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
