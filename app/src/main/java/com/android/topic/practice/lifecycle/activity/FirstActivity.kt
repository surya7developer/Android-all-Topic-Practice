package com.android.topic.practice.lifecycle.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.android.topic.practice.R
import com.android.topic.practice.common.showLog

class FirstActivity : ComponentActivity() {

    val TAG = "FirstActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        showLog(tag = TAG,"FirstActivity onCreate()")
    }

    override fun onStart() {
        super.onStart()
        showLog(tag = TAG,"FirstActivity onStart()")
    }

    override fun onResume() {
        super.onResume()
        showLog(tag = TAG,"FirstActivity onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        showLog(tag = TAG,"FirstActivity onRestart()")
    }

    override fun onPause() {
        super.onPause()
        showLog(tag = TAG,"FirstActivity onPause()")
    }

    override fun onStop() {
        super.onStop()
        showLog(tag = TAG,"FirstActivity onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        showLog(tag = TAG,"FirstActivity onDestroy()")
    }
}