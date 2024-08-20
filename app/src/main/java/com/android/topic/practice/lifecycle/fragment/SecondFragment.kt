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
import com.android.topic.practice.databinding.SecondFragmentBinding


class SecondFragment : Fragment() {

    val TAG = "TagForCheckFragmentLifecycle"
    private lateinit var binding: SecondFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().showLog(tag = TAG,"SecondFragment onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().showLog(tag = TAG,"SecondFragment onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SecondFragmentBinding.inflate(layoutInflater)
        requireActivity().showLog(tag = TAG,"SecondFragment onCreateView()")

        binding.openFirstFragment.setOnClickListener {
            ActivityToOpenFragment.activityToOpenFragment?.openFragment(FirstFragment())
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().showLog(tag = TAG,"SecondFragment onViewCreated()")
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        requireActivity().showLog(tag = TAG,"SecondFragment onViewStateRestored()")
    }

    override fun onStart() {
        super.onStart()
        requireActivity().showLog(tag = TAG,"SecondFragment onStart()")
    }

    override fun onResume() {
        super.onResume()
        requireActivity().showLog(tag = TAG,"SecondFragment onResume()")
    }

    override fun onPause() {
        super.onPause()
        requireActivity().showLog(tag = TAG,"SecondFragment onPause()")
    }

    override fun onStop() {
        super.onStop()
        requireActivity().showLog(tag = TAG,"SecondFragment onStop()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        requireActivity().showLog(tag = TAG,"SecondFragment onSaveInstanceState()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().showLog(tag = TAG,"SecondFragment onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().showLog(tag = TAG,"SecondFragment onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().showLog(tag = TAG,"SecondFragment onDetach()")
    }

}