package com.android.topic.practice.thread_and_coroutines

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.topic.practice.R
import com.android.topic.practice.databinding.ActivityThreadBinding
import com.android.topic.practice.extension.printLog
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreadBinding
    val TAG : String = "ThreadActivity"

    private fun updateCounter() {
        printLog(TAG,"updateCounter : Thread Name = ${Thread.currentThread().name}")
        binding.txtCounter.text = "${binding.txtCounter.text.toString().toInt() + 1}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCounterUpdate.setOnClickListener {
            updateCounter()
        }

        binding.btnExecuteLongRunningTaskInMainThread.setOnClickListener {
            longRunningTaskWithMainThread()
        }

        binding.btnExecuteLongRunningTaskInAnotherThread.setOnClickListener {
            longRunningTaskWithAnotherThread()
        }
    }

    private fun longRunningTaskWithMainThread() {
        printLog(TAG,"longRunningTaskWithMainThread : Thread Name = ${Thread.currentThread().name}")
        for(i in 1..1000000000L){

        }
    }

    private fun longRunningTaskWithAnotherThread() {
        thread(start = true) {
            printLog(TAG,"longRunningTaskWithAnotherThread : Thread Name = ${Thread.currentThread().name}")
            for(i in 1..1000000000L){

            }
        }
    }
}