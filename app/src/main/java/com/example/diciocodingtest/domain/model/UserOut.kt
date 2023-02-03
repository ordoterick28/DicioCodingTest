package com.example.diciocodingtest.domain.model

import com.google.gson.annotations.SerializedName

data class UserOut (
    @SerializedName("nombre")
    val name: String? = "",
    @SerializedName("apellidoPaterno")
    val firstFamilyName: String? = "",
    @SerializedName("apellidoMaterno")
    val secondFamilyName: String? = "",
    @SerializedName("edad")
    val age: Int?,
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("fechaNac")
    val dob: String? = "",
    @SerializedName("datos")
    val info: String? = ""
)