package com.android.topic.practice.lifecycle.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.topic.practice.R
import com.android.topic.practice.common.showLog
import com.android.topic.practice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    val TAG = "TagForCheckActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showLog(tag = TAG,"SecondActivity onCreate()")

        binding.backToFirstActivity.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.startFirstActivity.setOnClickListener {
            startActivity(Intent(this@SecondActivity,FirstActivity::class.java))
        }
        binding.startFirstActivityAndFinishThis.setOnClickListener {
            startActivity(Intent(this@SecondActivity,FirstActivity::class.java))
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        showLog(tag = TAG,"SecondActivity onStart()")
    }

    override fun onResume() {
        super.onResume()
        showLog(tag = TAG,"SecondActivity onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        showLog(tag = TAG,"SecondActivity onRestart()")
    }

    override fun onPause() {
        super.onPause()
        showLog(tag = TAG,"SecondActivity onPause()")
    }

    override fun onStop() {
        super.onStop()
        showLog(tag = TAG,"SecondActivity onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        showLog(tag = TAG,"SecondActivity onDestroy()")
    }
}