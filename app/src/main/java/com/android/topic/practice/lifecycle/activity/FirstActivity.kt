package com.android.topic.practice.lifecycle.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.topic.practice.common.showLog
import com.android.topic.practice.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding
    val TAG = "TagForCheckActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showLog(tag = TAG,"FirstActivity onCreate()")

        binding.openDialog.setOnClickListener {
            showAlertDialog()
        }

        binding.openSecondActivity.setOnClickListener {
            startActivity(Intent(this@FirstActivity,SecondActivity::class.java))
        }

        binding.openSecondActivityFinishFirst.setOnClickListener {
            startActivity(Intent(this@FirstActivity,SecondActivity::class.java))
            finish()
        }
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

    private fun showAlertDialog(){
        val builder = AlertDialog.Builder(this)
            .setTitle("Alert Title")
            .setMessage("This is an alert message.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        // Show the dialog
        val dialog = builder.create()
        dialog.show()
    }
}