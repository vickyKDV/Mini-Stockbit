package com.vickykdv.mystockbit.view.ui.portofolio

import android.os.Bundle
import android.view.View
import com.vickykdv.mystockbit.base.BaseFragment
import com.vickykdv.mystockbit.databinding.FragmentPortofolioBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PortofolioFragment : BaseFragment() {

    private val viewModel: PortofolioViewModel by viewModel()

    private val binding by lazy {
        FragmentPortofolioBinding.inflate(layoutInflater)
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