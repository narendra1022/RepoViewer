package com.example.repoviewer.model.api

import com.example.repoviewer.model.model.RepositoryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{username}/repos")
    suspend fun getRepositories(@Path("username") username: String): List<RepositoryDto>
}