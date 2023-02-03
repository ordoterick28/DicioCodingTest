package com.example.diciocodingtest.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class InfoOut (
    @SerializedName("calle")
    val street: String? = "",
    @SerializedName("numero")
    val number: String? = "",
    @SerializedName("colonia")
    val neighborhood: String? = "",
    @SerializedName("delegacion")
    val municipality: String? = "",
    @SerializedName("estado")
    val state: String = "",
    @SerializedName("cp")
    val zipCode: String = "",
    @SerializedName("imagen")
    val image: String? = "",
)