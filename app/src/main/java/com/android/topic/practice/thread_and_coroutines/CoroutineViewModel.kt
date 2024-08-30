package com.android.topic.practice.thread_and_coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineViewModel : ViewModel(){

    init {

        viewModelScope.launch {
            Log.d("CoroutineActivity","coroutineContext = $coroutineContext")

            while(true){
                delay(500)
                Log.d("CoroutineActivity","viewmodel scope example")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("CoroutineActivity","CoroutineScope Viewmodel destroyed")
    }
}