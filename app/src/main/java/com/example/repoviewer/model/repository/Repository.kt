package com.example.repoviewer.model.repository

import com.example.repoviewer.model.api.ApiService
import com.example.repoviewer.model.model.RepositoryDto
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getRepositories(username: String): Result<List<RepositoryDto>> {
        return try {
            val response = apiService.getRepositories(username)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
