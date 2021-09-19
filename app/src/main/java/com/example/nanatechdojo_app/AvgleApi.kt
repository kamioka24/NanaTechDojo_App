package com.example.nanatechdojo_app

import com.example.nanatechdojo_app.model.AvCategory
import com.example.nanatechdojo_app.model.AvCollection
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AvgleApi {
    companion object {
        const val BASE_URL = "https://api.avgle.com/v1/"
    }
    @GET("categories")
    // コルーチンの中でのみ呼び出すことができる suspend (非同期処理)
    fun getAvCategories(): Call<AvCategory>

    @GET("collections/1")
    fun getAvCollections(): Call<AvCollection>
}