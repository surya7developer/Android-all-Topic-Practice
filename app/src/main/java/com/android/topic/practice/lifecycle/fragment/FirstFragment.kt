package com.android.topic.practice.lifecycle.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.topic.practice.R
import com.android.topic.practice.common.showLog
import com.android.topic.practice.databinding.FragmentFirstragmentBinding

class FirstFragment : Fragment() {

    val TAG = "TagForCheckFragmentLifecycle"
    private lateinit var binding: FragmentFirstragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().showLog(tag = TAG,"FirstFragment onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().showLog(tag = TAG,"FirstFragment onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstragmentBinding.inflate(layoutInflater)
        requireActivity().showLog(tag = TAG,"FirstFragment onCreateView()")

        binding.openSecondFragment.setOnClickListener {
            ActivityToOpenFragment.activityToOpenFragment?.openFragment(SecondFragment())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().showLog(tag = TAG,"FirstFragment onViewCreated()")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        requireActivity().showLog(tag = TAG,"FirstFragment onViewStateRestored()")
    }

    override fun onStart() {
        super.onStart()
        requireActivity().showLog(tag = TAG,"FirstFragment onStart()")
    }

    override fun onResume() {
        super.onResume()
        requireActivity().showLog(tag = TAG,"FirstFragment onResume()")
    }

    override fun onPause() {
        super.onPause()
        requireActivity().showLog(tag = TAG,"FirstFragment onPause()")
    }

    override fun onStop() {
        super.onStop()
        requireActivity().showLog(tag = TAG,"FirstFragment onStop()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        requireActivity().showLog(tag = TAG,"FirstFragment onSaveInstanceState()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().showLog(tag = TAG,"FirstFragment onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().showLog(tag = TAG,"FirstFragment onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().showLog(tag = TAG,"FirstFragment onDetach()")
    }
}