package com.android.topic.practice.fragmentcontainerview

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.topic.practice.R
import com.android.topic.practice.databinding.ActivityFragmentContainerViewBinding

class FragmentContainerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentContainerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentContainerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // Only add the fragment if there is no saved instance state
            val fragment = FragmentContainerViewExample()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
}