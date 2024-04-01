package com.shushprasad.network.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface MovieCallback<T> : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            onSuccess(response.body()!!)
        } else {
            onFailure(Throwable("Failed to fetch data"))
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure(t)
    }

    fun onSuccess(data: T)
    fun onFailure(error: Throwable)
}

