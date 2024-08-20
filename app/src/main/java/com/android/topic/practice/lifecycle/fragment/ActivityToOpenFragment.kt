package com.android.topic.practice.lifecycle.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.android.topic.practice.R
import com.android.topic.practice.common.showLog
import com.android.topic.practice.databinding.ActivityToOpenFragmentBinding


class ActivityToOpenFragment : AppCompatActivity() {

    val TAG = "TagForCheckFragmentLifecycle"

    private var currentFragment: Fragment? = null
    private lateinit var binding: ActivityToOpenFragmentBinding
    companion object {
        var activityToOpenFragment: ActivityToOpenFragment? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityToOpenFragment = this
        binding = ActivityToOpenFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showLog(tag = TAG,"ActivityToOpenFragment onCreate()")

        binding.apply {

            openFirstFragment.setOnClickListener {
                openFragment(FirstFragment())
            }

            openSecondFragment.setOnClickListener {
                openFragment(SecondFragment())
            }

            removeCurrentOpenFragment.setOnClickListener {
                currentFragment?.let { it1 -> removeFragment(it1) }
            }

            popBackFragment.setOnClickListener {
                popFragment()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        showLog(tag = TAG,"ActivityToOpenFragment onStart()")
    }

    override fun onResume() {
        super.onResume()
        showLog(tag = TAG,"ActivityToOpenFragment onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        showLog(tag = TAG,"ActivityToOpenFragment onRestart()")
    }

    override fun onPause() {
        super.onPause()
        showLog(tag = TAG,"ActivityToOpenFragment onPause()")
    }

    override fun onStop() {
        super.onStop()
        showLog(tag = TAG,"ActivityToOpenFragment onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        showLog(tag = TAG,"ActivityToOpenFragment onDestroy()")
    }


    fun openFragment(fragment: Fragment) {
        currentFragment = fragment

        // Begin the fragment transaction
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Add or replace the fragment in the container
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)

        // Optionally, add the transaction to the back stack
        fragmentTransaction.addToBackStack(null)

        // Commit the transaction
        fragmentTransaction.commit()
    }

    fun removeFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Remove the fragment
        fragmentTransaction.remove(fragment)

        // Optionally, add the transaction to the back stack
        //fragmentTransaction.addToBackStack(null)

        // Commit the transaction
        fragmentTransaction.commit()

        currentFragment = null
    }

    fun popFragment() {
        val fragmentManager: FragmentManager = supportFragmentManager

        // Pop the back stack
        fragmentManager.popBackStack()

        // Pop back to a specific fragment tag
        //fragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}