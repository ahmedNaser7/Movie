package com.example.moviesapp.movie.presentation.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.domain.datasource.BrowseDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class BrowseViewModel(
    private val browseDataSource:BrowseDataSource
):ViewModel() {
    private val _state = MutableStateFlow(BrowseState())
    val state = _state.asStateFlow()
        .onStart { getTitleOfCategories() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            BrowseState()
        )

    fun getTitleOfCategories(){
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            try {
               val categories = browseDataSource.getCategoryTitle().genres!!
                _state.update { it.copy(categories = categories, isSuccess = true, isLoading = false) }
            }catch (e:Exception){
                _state.update { it.copy(error = e.message.toString(), isLoading = false) }
            }
        }
    }
}