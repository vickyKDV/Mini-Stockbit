package com.vickykdv.mystockbit.view.ui.watchlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.vickykdv.mystockbit.model.DataItem
import com.vickykdv.mystockbit.network.repository.RemoteRepo
import com.vickykdv.mystockbit.network.state.WatchListState

class WatchListViewModel(private val repository: RemoteRepo):ViewModel(){

    val isError = MutableLiveData<Boolean>().apply { value = false }
    val isLoading = MutableLiveData<Boolean>().apply { value = true }



    val callback : MutableLiveData<WatchListState> by lazy {
        MutableLiveData<WatchListState>()
    }

    val data : MutableLiveData<PagedList<DataItem>> by lazy {
        MutableLiveData<PagedList<DataItem>>()
    }

    fun getWatchListData(){
        repository.getWatchList(callback, data)
    }
}