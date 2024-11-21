package com.example.repoviewer.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.repoviewer.util.UiState
import com.example.repoviewer.viewmodel.GitViewModel

@Composable
fun GitHubSearchScreen(viewModel: GitViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsState()
    var username by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                title = {
                    Text(
                        text = "Repo Search",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)

            ) {
                SearchBar(
                    username = username,
                    onValueChange = { username = it },
                    onSearchClicked = { viewModel.fetchRepositories(username) }
                )

                when (uiState) {
                    is UiState.Idle -> IdleState()
                    is UiState.Loading -> LoadingState()
                    is UiState.Success -> {
                        val repositories = (uiState as UiState.Success).repositories
                        if (repositories.isEmpty()) NoRepositoriesState()
                        else RepositoryList(repositories)
                    }

                    is UiState.Error -> ErrorState(message = "Username cannot be empty.")
                    is UiState.InvalidUsername -> InvalidUsernameState()
                    is UiState.NoRepositories -> NoRepositoriesState()
                }
            }
        }
    )
}
