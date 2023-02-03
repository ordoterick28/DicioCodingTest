package com.example.diciocodingtest.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class User (
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("nombre")
    val name: String?,
    @SerializedName("apellidoPaterno")
    val firstFamilyName: String?,
    @SerializedName("apellidoMaterno")
    val secondFamilyName: String?,
    @SerializedName("edad")
    val age: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("fechaNac")
    val dob: String?
)