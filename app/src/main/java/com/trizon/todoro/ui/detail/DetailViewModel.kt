package com.trizon.todoro.ui.detail

import androidx.lifecycle.ViewModel
import com.trizon.todoro.data.repository.TodoroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val todoroRepository: TodoroRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.LoadDetail -> _uiState.value = DetailUiState.Content(event.id)
        }
    }
}
