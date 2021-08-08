package com.vickykdv.mystockbit.view.ui.watchlist

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vickykdv.mystockbit.adapter.LoadWatchListAdapter
import com.vickykdv.mystockbit.adapter.WatchListAdapter
import com.vickykdv.mystockbit.base.BaseFragment
import com.vickykdv.mystockbit.databinding.FragmentWatchlistBinding
import com.vickykdv.mystockbit.extension.ExtentionUtils.hide
import com.vickykdv.mystockbit.extension.ExtentionUtils.onClick
import com.vickykdv.mystockbit.extension.ExtentionUtils.show
import com.vickykdv.mystockbit.extension.ExtentionUtils.showToast
import com.vickykdv.mystockbit.model.DataItem
import com.vickykdv.mystockbit.network.state.WatchListState
import com.vickykdv.mystockbit.utils.CustomDividerDecoration
import com.vickykdv.mystockbit.utils.CustomDividerDecoration.Companion.VERTICAL
import com.vickykdv.mystockbit.utils.UtilsHelper
import com.vickykdv.mystockbit.view.main.MainPage
import org.koin.androidx.viewmodel.ext.android.viewModel

class WatchListFragment : BaseFragment() {

    private val viewModel: WatchListViewModel by viewModel()
    private val list = listOf(1,2,3,4,6,7,8,9,10)
    private val adapter  by lazy {
        WatchListAdapter {
                item -> showDetail(item)
        }
    }

    private val loadAdapter by lazy {
        LoadWatchListAdapter()
    }

    private val binding by lazy {
        FragmentWatchlistBinding.inflate(layoutInflater)
    }

    override fun setLayout(): View {
        return binding.root
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        setView()
        setupObservable()
        viewModel.getWatchListData()
    }

    private fun setView(){
        with(binding){
            loadAdapter.updateData(list)
            rvShimmer.also {
                it.adapter = loadAdapter
                it.layoutManager = LinearLayoutManager(context)
                it.addItemDecoration(CustomDividerDecoration(requireContext(),
                    VERTICAL,
                    false,100))
                it.setHasFixedSize(true)
            }
            rv.also {
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(context)
                it.addItemDecoration(CustomDividerDecoration(requireContext(),
                    VERTICAL,
                    false,100))
                it.setHasFixedSize(true)
            }


            swipeRefresh.setOnRefreshListener {
                Handler().postDelayed({
                    viewModel.getWatchListData()
                }, 500)

            }
        }
    }

    private fun setupObservable(){
        viewModel.isError.observe(this, {
            if(it) {

                viewModel.isLoading.value = false
                with(binding) {
                    swipeRefresh.isRefreshing = false
                    shimmer.stopShimmer()
                    shimmer.hide()
                    rv.hide()
                    rlError.show()
                    btnRefresh.onClick {
                        viewModel.getWatchListData()
                    }
                }
            }
        })

        viewModel.isLoading.observe(this,{
            viewModel.isError.value = false
            with(binding){
                if(it) {
                    shimmer.startShimmer()
                    shimmer.show()
                    rlError.hide()
                    rv.hide()
                }else{
                    shimmer.stopShimmer()
                    shimmer.hide()
                    rv.show()
                    rlError.hide()
                    swipeRefresh.isRefreshing = false
                }
            }
        })

        viewModel.callback.observe(this,{
            when(it){
                is WatchListState.Loading -> {
                    viewModel.isLoading.value = true
                }
                is WatchListState.Result -> {
                    viewModel.isLoading.value = false
                }
                is WatchListState.Error -> {
                    viewModel.isError.value = true
                }
            }
        })
        viewModel.data.observe(this, Observer(adapter::submitList))
    }


    private fun showDetail(item: DataItem) {
        Log.d("WATCHLIST", "showDetail: ${item.rAW}")
        (activity as MainPage).showToast(UtilsHelper.formatCurrencyChanges(item))
    }

}