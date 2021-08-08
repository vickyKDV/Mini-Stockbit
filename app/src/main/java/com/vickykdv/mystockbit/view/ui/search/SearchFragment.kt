package com.vickykdv.mystockbit.view.ui.search

import android.os.Bundle
import android.view.View
import com.vickykdv.mystockbit.base.BaseFragment
import com.vickykdv.mystockbit.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment() {

    private val viewModel: SearchViewModel by viewModel()

    private val binding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
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