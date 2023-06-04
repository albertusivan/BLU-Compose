package com.example.blu_compose.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blu_compose.data.Repository
import com.example.blu_compose.model.OrderCampus
import com.example.blu_compose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderCampus>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderCampus>>
    get() = _uiState

    fun getCampusById(rewardId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderCampusById(rewardId))
        }
    }
}