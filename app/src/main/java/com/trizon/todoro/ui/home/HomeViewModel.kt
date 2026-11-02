package com.trizon.todoro.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trizon.todoro.data.model.Resource
import com.trizon.todoro.domain.usecase.GetTodorosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTodorosUseCase: GetTodorosUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.LoadTodoros -> loadTodoros()
        }
    }

    private fun loadTodoros() {
        viewModelScope.launch {
            getTodorosUseCase().collect { resource ->
                _uiState.value = when (resource) {
                    is Resource.Loading -> HomeUiState.Loading
                    is Resource.Success -> HomeUiState.Success(resource.data)
                    is Resource.Error -> HomeUiState.Error(resource.errorMessage)
                }
            }
        }
    }
}
