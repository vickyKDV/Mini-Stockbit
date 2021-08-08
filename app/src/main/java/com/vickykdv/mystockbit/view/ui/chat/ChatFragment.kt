package com.vickykdv.mystockbit.view.ui.chat

import android.os.Bundle
import android.view.View
import com.vickykdv.mystockbit.base.BaseFragment
import com.vickykdv.mystockbit.databinding.FragmentChatBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatFragment : BaseFragment() {

    private val viewModel: ChatViewModel by viewModel()

    private val binding by lazy {
        FragmentChatBinding.inflate(layoutInflater)
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