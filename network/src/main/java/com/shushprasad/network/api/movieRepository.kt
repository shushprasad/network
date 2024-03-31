package com.shushprasad.network.api

import com.shushprasad.network.api.model.MovieDetail
import com.shushprasad.network.api.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback

object MovieRepository {
    private const val API_KEY = "909594533c98883408adef5d56143539"
    private var movieId = 1
    private val networkService: MovieApiService by lazy {
        RetrofitClient.getClient().create(MovieApiService::class.java)
    }

    suspend fun getLatestMovie(callback: Callback<MovieResponse>) {
        val call: Call<MovieResponse> = networkService.getLatestMovies(API_KEY)
        call.enqueue(callback)
    }
    suspend fun getPopularMovie(callback: Callback<MovieResponse>) {
        val call: Call<MovieResponse> = networkService.getPopularMovies(API_KEY)
        call.enqueue(callback)
    }
    suspend fun getMovieDetails(callback: Callback<MovieDetail>) {
        val call: Call<MovieDetail> = networkService.getMovieDetails(movieId,API_KEY)
        call.enqueue(callback)
    }

}