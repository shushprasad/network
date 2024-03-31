package com.shushprasad.network.api

interface MovieCallback<T> {
    fun onSuccess(data: T)
    fun onFailure(error: Throwable)
}
