package com.vickykdv.mystockbit.network.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.vickykdv.mystockbit.model.DataItem
import com.vickykdv.mystockbit.network.ApiService
import com.vickykdv.mystockbit.network.state.WatchListState
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WatchListDataSource(private val apiService: ApiService) : PageKeyedDataSource<Int,DataItem>(){

    lateinit var liveData: MutableLiveData<WatchListState>

    private val disposable by lazy {
        CompositeDisposable()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DataItem>
    ) {
        apiService.getWatchList("IDR",1,20)
            .map<WatchListState> {

                it.data.let {
                        it1 -> callback.onResult(it1.toMutableList(),1,2)
                }
                WatchListState.Result(it)

            }
            .onErrorReturn(WatchListState::Error)
            .toFlowable()
            .startWith(WatchListState.Loading)
            .subscribe(liveData::postValue)
            .let { return@let disposable::add }
    }



    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataItem>) {
        apiService.getWatchList("IDR",params.key,20)
            .map<WatchListState> {
                it.data.let { it1 -> callback.onResult(it1.toMutableList(),params.key + 1) }
                WatchListState.Result(it)
            }
            .onErrorReturn(WatchListState::Error)
            .toFlowable()
            .subscribe(liveData::postValue)
            .let { return@let disposable::add }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataItem>) {

    }


}
