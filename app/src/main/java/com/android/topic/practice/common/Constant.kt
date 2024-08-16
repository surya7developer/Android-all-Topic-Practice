package com.android.topic.practice.common

import android.content.Context
import android.util.Log

fun Context.showLog(tag: String, message: String) {
    Log.d(tag, message)
}