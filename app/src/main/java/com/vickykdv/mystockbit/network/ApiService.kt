package com.vickykdv.mystockbit.network

import com.vickykdv.mystockbit.model.CryptoModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/top/totaltoptiervolfull")
    fun getWatchList(
        @Query("tsym") tsym: String,
        @Query("page") page : Int,
        @Query("limit") limit : Int
    ) : Single<CryptoModel>
}