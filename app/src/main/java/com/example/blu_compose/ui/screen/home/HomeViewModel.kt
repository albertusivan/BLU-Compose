package com.example.blu_compose.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blu_compose.data.Repository
import com.example.blu_compose.model.OrderCampus
import com.example.blu_compose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderCampus>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderCampus>>>
        get() = _uiState

    fun getAllCampus() {
        viewModelScope.launch {
            repository.getAllCampus()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderCampus ->
                    _uiState.value = UiState.Success(orderCampus)
                }
        }
    }
}