package com.boo.sample.sampleeventbus

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.boo.sample.sampleeventbus.databinding.ActivityChildBinding
import org.greenrobot.eventbus.EventBus

class ChildActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityChildBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChildBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.triggerEventButton.setOnClickListener { view ->
            val userText = binding.messageEditText.text.toString()
            val event = CustomMessageEvent()
            event.setCustomMessage(userText)
             EventBus.getDefault().post(event)

            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_child)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}