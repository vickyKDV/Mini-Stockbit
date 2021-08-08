package com.vickykdv.mystockbit.network.state

import com.vickykdv.mystockbit.model.CryptoModel


sealed class WatchListState {
    object Loading : WatchListState()
    data class Result(val data : CryptoModel) : WatchListState()
    data class Error(val error : Throwable) : WatchListState()
}
