package com.shushprasad.network.api

import android.util.Log

import com.shushprasad.network.api.model.MovieResponse
import com.shushprasad.network.api.model.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRepository {

    fun getLatestMovies(
        page: Int = 1,
        onSuccess: (movies: MutableList<Movies>) -> Unit,
        onError: () -> Unit
    ) {
        val movieApiService = RetrofitClient.getClient().create(MovieApiService::class.java)
        movieApiService.getLatestMovies(page = page)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        Log.d("Latest","Movie1: "+response.body())
                        if (responseBody != null) {
                            val mutableMovies = responseBody.movies.toMutableList()
                            onSuccess.invoke(mutableMovies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
    fun getPopularMovies(
        page: Int = 1,
        onSuccess: (movies: MutableList<Movies>) -> Unit,
        onError: () -> Unit
    ) {
        val movieApiService = RetrofitClient.getClient().create(MovieApiService::class.java)
        movieApiService.getPopularMovies(page = page)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            val mutableMovies = responseBody.movies.toMutableList()
                            onSuccess.invoke(mutableMovies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}
