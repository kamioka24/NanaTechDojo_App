package com.example.nanatechdojo_app.repository

import com.example.nanatechdojo_app.AvgleApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class AvRepository {
    // Retrofit の実体化
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(AvgleApi.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(AvgleApi::class.java)
}