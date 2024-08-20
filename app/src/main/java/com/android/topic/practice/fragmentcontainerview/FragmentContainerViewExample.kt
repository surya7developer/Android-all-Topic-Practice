package com.android.topic.practice.fragmentcontainerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.topic.practice.databinding.FragmentContainerViewExampleBinding

class FragmentContainerViewExample : Fragment() {

    private lateinit var binding: FragmentContainerViewExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentContainerViewExampleBinding.inflate(inflater, container, false)
        return binding.root

    }
}