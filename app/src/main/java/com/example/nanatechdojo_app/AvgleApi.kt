package com.example.nanatechdojo_app

import com.example.nanatechdojo_app.model.AvCategory
import retrofit2.Response
import retrofit2.http.GET

interface AvgleApi {
    companion object {
        const val BASE_URL = "https://api.avgle.com/v1/"
    }
    @GET("categories")
    // API 通信は必ず suspend
    suspend fun getAvCategories(): Response<AvCategory>
}