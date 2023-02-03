package com.example.diciocodingtest.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Info (
    @SerializedName("calle")
    val street: String?,
    @SerializedName("imagen")
    val image: String?,
)