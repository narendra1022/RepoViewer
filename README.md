# GitHub Repository Viewer App

A simple Android application that allows users to search for a GitHub username and view their repositories, with features such as error handling and different UI states (loading, empty, success, error). 
I have used modern Android development tools and libraries like Jetpack Compose, Hilt, and Kotlin Coroutines to provide a smooth user experience.

## Setup Instructions

 Prerequisites
- Android Studio (preferably the latest version)
- Android SDK (API level 21 or higher)

Step 1: Clone the Repository

To clone the repository to your local machine, run the following command in your terminal:

git clone https://github.com/narendra1022/RepoViewer.git

Step 2: Open in Android Studio

After cloning the repository, open **Android Studio**. Choose **Open an existing project** and navigate to the cloned repository folder to open it.

Step 3: Sync Gradle

Once the project is opened in Android Studio, Gradle should automatically sync. If not, go to **File > Sync Project with Gradle Files** to manually sync.


## Architecture Overview

This app follows the **MVVM (Model-View-ViewModel)** architecture, to ensure separation of concerns and maintainability.

- **Model**: Represents the data layer of the app. It fetches repository data from GitHub's API.
- **View**: The UI layer built using Jetpack Compose. This layer displays the data and handles user interactions.
- **ViewModel**: Acts as the intermediary between the Model and the View. It contains the business logic, manages UI states, and exposes data to the View.
- **Repository Pattern**: The repository is responsible for providing data to the ViewModel. It abstracts the data source (GitHub API in this case) and is the single source of truth for fetching data.


## Utilised

- **Jetpack Compose**: The UI toolkit for building native UIs in a declarative way.
  
- **Hilt**: Dependency injection library for Android. Simplifies dependency management by providing automatic injection.
  
- **Kotlin Coroutines**: For handling asynchronous operations, including network requests.
  
- **Retrofit**: A type-safe HTTP client for making network requests and interacting with REST APIs.


## Core Implementations

1. **Error Handling**:
   - **Invalid Username**: If the entered username is incorrect (not found), the app displays an error message: "User not found."
   - **No Repositories**: If the username is valid but has no repositories, a message indicating "User doesn’t have any repositories" is shown.
   - **Network Issues**: In case of network failure, an appropriate error message is shown to the user.

2. **UI States**:
   - **Idle State**: Shows a prompt for the user to enter a GitHub username.
   - **Loading State**: Displays a progress indicator while repositories are being fetched.
   - **Success State**: Displays a list of repositories once the data is fetched successfully.
   - **Error State**: Displays an error message if there is a failure (invalid username or network issues).
   - **Empty State**: Shows a message if the username has no repositories.

3. **UI Design**:
   - The app is designed to be simple, clean, and intuitive. It uses **Jetpack Compose** for building modern, responsive, and declarative UIs.
   - The design includes a **TextField** for username input and a **Button** to trigger the search. A **LazyColumn** is used to display the repositories in a scrollable list.

4. **Repository Pattern**:
   - The **Repository** class abstracts the logic of fetching data from the GitHub API, making it easier to manage and test the data layer separately from the ViewModel.
   
5. **StateFlow for ViewModel**:
   - `StateFlow` is used to manage and expose the UI state in a reactive manner. This helps the ViewModel remain lifecycle-aware while keeping the UI decoupled from business logic.

  The code is structured in a modular way following best practices in clean architecture. 

