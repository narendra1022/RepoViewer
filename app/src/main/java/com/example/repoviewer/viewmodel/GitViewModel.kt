package com.example.repoviewer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repoviewer.model.repository.Repository
import com.example.repoviewer.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState

    fun fetchRepositories(username: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            if (username.isBlank()) {
                _uiState.value = UiState.Error("Username cannot be empty.")
                return@launch
            }

            val result = repository.getRepositories(username)

            _uiState.value = if (result.isSuccess) {
                val repositories = result.getOrThrow()
                if (repositories.isEmpty()) {
                    UiState.NoRepositories
                } else {
                    UiState.Success(repositories)
                }
            } else {
                UiState.InvalidUsername
            }
        }
    }
}



