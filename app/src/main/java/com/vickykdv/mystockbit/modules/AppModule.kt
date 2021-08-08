package com.vickykdv.mystockbit.modules

import androidx.paging.PagedList
import com.vickykdv.mystockbit.network.factory.Factory
import com.vickykdv.mystockbit.network.factory.WatchListDataFactory
import com.vickykdv.mystockbit.network.repository.RemoteRepo
import com.vickykdv.mystockbit.network.source.WatchListDataSource
import com.vickykdv.mystockbit.view.login.LoginViewModel
import com.vickykdv.mystockbit.view.ui.chat.ChatViewModel
import com.vickykdv.mystockbit.view.ui.portofolio.PortofolioViewModel
import com.vickykdv.mystockbit.view.ui.search.SearchViewModel
import com.vickykdv.mystockbit.view.ui.stream.StreamViewModel
import com.vickykdv.mystockbit.view.ui.watchlist.WatchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    single {
        PagedList.Config.Builder()
            .setPageSize(1)
            .setInitialLoadSizeHint(2)
            .setPrefetchDistance(1)
            .setEnablePlaceholders(true)
            .build()
    }


}

val RepoModule = module {
    single { RemoteRepo(get(),get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { WatchListViewModel(get()) }
    viewModel { StreamViewModel() }
    viewModel { SearchViewModel() }
    viewModel { ChatViewModel() }
    viewModel { PortofolioViewModel() }
}

val FactoryModule = module {
    factory { Factory(get()) }
    factory { WatchListDataFactory(get()) }
}

val DataSourceModule = module {
    single { WatchListDataSource(get()) }
}