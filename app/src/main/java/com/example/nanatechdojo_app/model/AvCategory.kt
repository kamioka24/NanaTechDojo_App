package com.example.nanatechdojo_app.model

import com.squareup.moshi.Json

data class AvCategory(
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