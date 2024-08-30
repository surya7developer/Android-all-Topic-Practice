package com.android.topic.practice.extension

import android.content.Context
import android.content.Intent
import android.util.Log

fun Context.openScreen(path:Class<*>){
    startActivity(Intent(this,path))
}

fun Context.printLog(tag:String,msg:String){
    Log.e(tag,msg)
}