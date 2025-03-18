package com.example.moviesapp.di

import com.example.moviesapp.core.data.network.RetrofitInstance
import com.example.moviesapp.movie.presentation.home.HomeViewModel
import com.example.moviesapp.MovieViewModel
import com.example.moviesapp.core.data.datasource.HomeDataSourceImpl
import com.example.moviesapp.core.domain.datasource.HomeDataSource
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single { RetrofitInstance }
    single { get<RetrofitInstance>().movieService }
    singleOf(::HomeDataSourceImpl) { bind<HomeDataSource>() }
    viewModelOf(::MovieViewModel)
    viewModelOf(::HomeViewModel)
}