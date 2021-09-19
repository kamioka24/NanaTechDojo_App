package com.example.nanatechdojo_app.model

import com.squareup.moshi.JsonClass

data class AvCollection(val success: Boolean, val response: Response) {
    data class Response(
        val collections: List<Collection>
    ) {
        @JsonClass(generateAdapter = true)
        data class Collection(
            val id: String,
            val title: String,
        )
    }
}