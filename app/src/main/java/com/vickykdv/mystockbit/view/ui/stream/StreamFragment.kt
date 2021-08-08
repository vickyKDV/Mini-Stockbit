package com.vickykdv.mystockbit.view.ui.stream

import android.os.Bundle
import android.view.View
import com.vickykdv.mystockbit.base.BaseFragment
import com.vickykdv.mystockbit.databinding.FragmentStreamBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StreamFragment : BaseFragment() {

    private val viewModel: StreamViewModel by viewModel()

    private val binding by lazy {
        FragmentStreamBinding.inflate(layoutInflater)
    }

    override fun setLayout(): View {
        return binding.root
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        viewModel.text.observe(viewLifecycleOwner, {
            binding.txt.text = it
        })
    }

}