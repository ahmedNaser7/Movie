# Movie Application

A simple and easy-to-use movie application built with Jetpack Compose and Kotlin, utilizing Retrofit for API calls. The app displays new releases and recommended movies, allows users to search for movies, and add them to their watchlist

## Screenshots

<img src="Screenshot Movie .png" alt="Screenshot">

## Features

- Home 
- Movie Details
- Search
- Browse 
- Browse Details
- WatchList

## Technologies Used

- [Jetpack Compose](https://developer.android.com/compose)
- [Retrofit ](https://square.github.io/retrofit/)
- [The Movie Database (TMDb) API](https://developer.themoviedb.org/docs/getting-started)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

## Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio)
- A Firebase project with Realtime Database and Authentication set up

### Installation

1. Clone the repository:
    ```sh
    https://github.com/ahmedNaser7/Movie.git
    ```
2. Open the project in Android Studio.

3. Sync the project with Gradle files.

### Configuration

. Set up api Authentication:
    - read the document of Movie Api


## Architecture

The application follows the MVVM (Model-View-ViewModel) architecture pattern for a clean separation of concerns and easy testability.

- **Model**: Contains the data classes and the repository for data handling.
- **View**: Includes the UI components and observes the data from the ViewModel.
- **ViewModel**: Acts as a bridge between the Model and the View, holding the UI data and handling logic.

