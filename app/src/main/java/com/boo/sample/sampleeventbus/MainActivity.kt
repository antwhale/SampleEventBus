package com.boo.sample.sampleeventbus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.boo.sample.sampleeventbus.databinding.ActivityMainBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        EventBus.getDefault().register(this)

        binding.launchButton.setOnClickListener { view ->
            val intent = Intent(this, ChildActivity::class.java)
            startActivity(intent)
        }
    }

    @Subscribe
    fun onEvent(event:CustomMessageEvent ){
        Log.d(TAG, "ElectronicArmory: Event fired ${event.getCustomMessage()}")
        binding.resultsEditText.setText(event.getCustomMessage())
    }
}