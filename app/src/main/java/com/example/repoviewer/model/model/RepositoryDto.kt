package com.example.repoviewer.model.model

data class RepositoryDto(
    val id: Int,
    val name: String,
    val description: String?,
    val stargazers_count: Int,
    val language: String?
)