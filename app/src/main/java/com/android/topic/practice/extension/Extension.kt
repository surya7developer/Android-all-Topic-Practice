package com.android.topic.practice.extension

import android.content.Context
import android.content.Intent

fun Context.openScreen(path:Class<*>){
    startActivity(Intent(this,path))
}