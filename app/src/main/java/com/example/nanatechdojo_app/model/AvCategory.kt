package com.example.nanatechdojo_app.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class AvCategory(
    val success: Boolean,
    val response: Response
) {
    data class Response(
        val categories: List<Category>
    ) {
        @JsonClass(generateAdapter = true)
        data class Category(
            @Json(name = "CHID")
            val chid: String,
            val name: String,
            val slug: String,
            @Json(name = "total_videos")
            val totalVideos: Int,
            @Json(name = "shortname")
            val shortName: String,
            @Json(name = "category_url")
            val categoryUrl: String,
            @Json(name = "cover_url")
            val coverUrl: String
        )
    }
}