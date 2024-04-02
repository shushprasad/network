package com.shushprasad.network.api


import com.shushprasad.network.api.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "909594533c98883408adef5d56143539",
        @Query("page") page: Int
    ): Call<MovieResponse>
    
    @GET("movie/upcoming")
    fun getLatestMovies(@Query("api_key") apiKey: String = "909594533c98883408adef5d56143539", @Query("page") page: Int
    ): Call<MovieResponse>
}
