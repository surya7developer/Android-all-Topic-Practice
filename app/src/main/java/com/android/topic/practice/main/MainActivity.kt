package com.android.topic.practice.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.topic.practice.databinding.ActivityMainBinding
import com.android.topic.practice.extension.openScreen
import com.android.topic.practice.fragmentcontainerview.FragmentContainerViewActivity
import com.android.topic.practice.lifecycle.activity.FirstActivity
import com.android.topic.practice.lifecycle.fragment.ActivityToOpenFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            activityAndLifecycle.setOnClickListener {
                // For Activity Lifecycle
                openScreen(FirstActivity::class.java)
            }

            openActivityForFragment.setOnClickListener {
                // For Fragment & its Lifecycle
                openScreen(ActivityToOpenFragment::class.java)
            }

            openFragmentContainerView.setOnClickListener {
                openScreen(FragmentContainerViewActivity::class.java)
            }
        }
    }
}