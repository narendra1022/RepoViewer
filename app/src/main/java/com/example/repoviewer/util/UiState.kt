package com.example.repoviewer.util

import com.example.repoviewer.model.model.RepositoryDto

sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    data class Success(val repositories: List<RepositoryDto>) : UiState()
    data class Error(val message: String) : UiState()
    object InvalidUsername : UiState()
    object NoRepositories : UiState()
}