package com.vickykdv.mystockbit.modules

import android.content.Context
import android.util.Log.VERBOSE
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ihsanbal.logging.LoggingInterceptor
import com.vickykdv.mystockbit.BuildConfig
import com.vickykdv.mystockbit.network.ApiService
import com.vickykdv.mystockbit.network.mock.MockInterceptor
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import com.github.simonpercic.oklog3.OkLogInterceptor
import okhttp3.logging.HttpLoggingInterceptor


val networkModule = module {
    single { providesHttpLoggingInterceptor() }
    single { providesApiKey() }
    single { providesChucker(androidContext()) }
    single { providesHttpClient(get(),get(),get()) }
    single { providesHttpAdapter(get()) }
    single { providesApiEndPoint(get()) }
}

fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = when (BuildConfig.DEBUG) {
            true -> HttpLoggingInterceptor.Level.BODY
            false -> HttpLoggingInterceptor.Level.NONE
        }
    }
}


fun providesChucker(context: Context): ChuckerInterceptor {
    return ChuckerInterceptor(context)
}

fun providesApiKey() : Interceptor = Interceptor { chain ->
    var request: Request = chain.request()
    val url: HttpUrl = request.url.newBuilder()
        .build()
    request = request.newBuilder().url(url).build()
    chain.proceed(request)
}

fun providesHttpClient(
    interceptor: HttpLoggingInterceptor,
    chucker: ChuckerInterceptor,
    apiKey: Interceptor,
): OkHttpClient {

    /**
     * HTTP LOG
     **/
    val httpLogg = LoggingInterceptor.Builder()
        .setLevel(if(BuildConfig.DEBUG) com.ihsanbal.logging.Level.BASIC else com.ihsanbal.logging.Level.NONE)
        .log(VERBOSE)
        .tag("LoggerZ")
        .request("LoggerZ")
        .response("LoggerZ")

    return OkHttpClient.Builder().apply {
        retryOnConnectionFailure(true)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
        addInterceptor(interceptor)
        addInterceptor(httpLogg.build())
        addInterceptor(MockInterceptor())
        if(BuildConfig.DEBUG) addInterceptor(chucker)
        addInterceptor(apiKey)
    }.build()
}

fun providesHttpAdapter(client: OkHttpClient): Retrofit {
    return Retrofit.Builder().apply {
        client(client)
        baseUrl(BuildConfig.api_base_url)
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
    }.build()
}

fun providesApiEndPoint(retrofit: Retrofit) : ApiService {
    return retrofit.create(ApiService::class.java)
}
