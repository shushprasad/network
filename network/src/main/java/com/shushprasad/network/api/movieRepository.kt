package com.shushprasad.network.api

class MovieRepository(private val apiService: MovieApiService) {
    suspend fun getPopularMovies(apiKey: String) = apiService.getPopularMovies(apiKey)
    suspend fun getLatestMovies(apiKey: String) = apiService.getLatestMovies(apiKey)
    suspend fun getMovieDetails(movieId: Int, apiKey: String) = apiService.getMovieDetails(movieId, apiKey)
}
