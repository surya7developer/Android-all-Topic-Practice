package com.android.topic.practice.lifecycle.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.topic.practice.R
import com.android.topic.practice.common.showLog

class SecondActivity : AppCompatActivity() {

    val TAG = "SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showLog(tag = TAG,"SecondActivity onCreate()")
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