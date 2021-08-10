package com.vickykdv.mystockbit

import android.app.Application
import com.vickykdv.mystockbit.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(viewModelModule, networkModule, RepoModule, FactoryModule, DataSourceModule,
                AppModule)
        }

    }
}