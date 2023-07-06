package com.hypetrack.whitelisting.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hypetrack.whitelisting.Whitelisting

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Whitelisting.showPrompt(this)
    }
}
