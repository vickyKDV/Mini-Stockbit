package com.vickykdv.mystockbit.network.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.vickykdv.mystockbit.model.DataItem
import com.vickykdv.mystockbit.network.factory.Factory
import com.vickykdv.mystockbit.network.state.WatchListState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RemoteRepo(
    private val config : PagedList.Config,
    private val factory : Factory
) {

    fun getWatchList(
        callback: MutableLiveData<WatchListState>,
        data: MutableLiveData<PagedList<DataItem>>
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            LivePagedListBuilder(
                factory.watchListDataFactory.also {
                    it.liveData = callback
                },
                config
            ).build().observeForever(data::postValue)
        }

    }
}