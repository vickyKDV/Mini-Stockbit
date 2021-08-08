package com.vickykdv.mystockbit.network.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.vickykdv.mystockbit.model.DataItem
import com.vickykdv.mystockbit.network.source.WatchListDataSource
import com.vickykdv.mystockbit.network.state.WatchListState

class WatchListDataFactory(
    private val watchListDataSource: WatchListDataSource
):DataSource.Factory<Int,DataItem>() {


    lateinit var liveData: MutableLiveData<WatchListState>

    override fun create(): DataSource<Int, DataItem> {
        return watchListDataSource.also {
            it.liveData = liveData
        }
    }

}
