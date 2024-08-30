package com.android.topic.practice.thread_and_coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.android.topic.practice.databinding.ActivityCoroutineBinding
import com.android.topic.practice.extension.printLog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class CoroutineActivity : AppCompatActivity() {
    private lateinit var coroutineViewModel: CoroutineViewModel
    private lateinit var binding: ActivityCoroutineBinding
    val TAG = "CoroutineActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coroutineViewModel = ViewModelProvider(this).get(CoroutineViewModel::class.java)

        binding.btnDestroyeViewmodelScope.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


        binding.btnLaunchCoroutine.setOnClickListener {
            launchCoroutine()
        }

        binding.btnCheckSuspendingFucntion.setOnClickListener {
            suspendingFunctionExample()
        }

        binding.btnCheckJobObjectOperations.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                jobObjectAndLaunchCoroutine()
            }
        }

        binding.btnCheckDeferredOperations.apply {
            CoroutineScope(Dispatchers.IO).launch {
                deferredObjectAndAsyncCoroutine()
            }
        }

        binding.btnCheckParallelExecution.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                printFollowersParallelExecution()
            }
        }

        binding.btnCheckSequentialExecution.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                printFollowersSequentialExecution()
            }
        }
    }

    private fun suspendingFunctionExample() {
        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }
    }

    private suspend fun task1() {
        printLog(TAG, "task1 start")
        yield()
        printLog(TAG, "task1 end")
    }

    private suspend fun task2() {
        printLog(TAG, "task2 start")
        yield()
        printLog(TAG, "task2 end")
    }


    private fun launchCoroutine() {

        CoroutineScope(Dispatchers.IO).launch {
            printLog(TAG, "CoroutineScope : Thread Name = ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main) {
            printLog(TAG, "GlobalScope : Thread Name = ${Thread.currentThread().name}")
        }

        MainScope().launch(Dispatchers.Default) {
            printLog(TAG, "MainScope : Thread Name = ${Thread.currentThread().name}")
        }

    }

    private suspend fun jobObjectAndLaunchCoroutine() {
        printLog(TAG, "Before uncommenting job.join() index - 2 will call first")
        printLog(TAG, "After uncommenting job.join() index - 1 will call first")

        val job = CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            printLog(TAG, "index - 1  we can return job object ")
        }


        //job.cancel() // For cancel job (Task)
        //job.join() // For suspend the function until job complete

        printLog(TAG, "index - 2 After job print this line ")
    }

    private suspend fun deferredObjectAndAsyncCoroutine() {
        val deferred = CoroutineScope(Dispatchers.IO).async {
            printLog(TAG, "index - 1 Deferred object operations")
            "Hello"
        }

        deferred.await() // For suspend the function until deferred return result

        printLog(TAG, "index 2 - $deferred")
    }

    private suspend fun printFollowersParallelExecution() {
        CoroutineScope(Dispatchers.IO).launch {
            val fb = async { getFbFollowers() }
            val insta = async { getInstaFollowers() }
            printLog(TAG, "FB = ${fb.await()}, Insta = ${insta.await()}")
        }
    }

    private suspend fun printFollowersSequentialExecution() {
        CoroutineScope(Dispatchers.IO).launch {
            val fb =  getFbFollowers()
            val insta =  getInstaFollowers()
            printLog(TAG, "FB = $fb, Insta = $insta")
        }
    }

    private suspend fun getFbFollowers(): Int {
        delay(100)
        return 110
    }


    private suspend fun getInstaFollowers(): Int {
        delay(100)
        return 150
    }

}

public class BBB {


}