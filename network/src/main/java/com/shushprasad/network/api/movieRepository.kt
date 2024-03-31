package com.shushprasad.network.api

import com.shushprasad.network.api.model.MovieDetail
import com.shushprasad.network.api.model.MovieResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object MovieRepository {
    private const val API_KEY = "909594533c98883408adef5d56143539"
    private var movieId = 1
    private val networkService: MovieApiService by lazy {
        RetrofitClient.getClient().create(MovieApiService::class.java)
    }

    fun getLatestMovie(callback: MovieCallback<MovieResponse>) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = networkService.getLatestMovies(API_KEY)
                callback.onSuccess(response)
            } catch (e: Throwable) {
                callback.onFailure(e)
            }
        }
    }

    fun getPopularMovie(callback: MovieCallback<MovieResponse>) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = networkService.getPopularMovies(API_KEY)
                callback.onSuccess(response)
            } catch (e: Throwable) {
                callback.onFailure(e)
            }
        }
    }

    fun getMovieDetails(callback: MovieCallback<MovieDetail>) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = networkService.getMovieDetails(movieId, API_KEY)
                callback.onSuccess(response)
            } catch (e: Throwable) {
                callback.onFailure(e)
            }
        }
    }
}
