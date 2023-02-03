package com.example.diciocodingtest.data.remote

import com.example.diciocodingtest.domain.model.User
import com.example.diciocodingtest.domain.model.UserOut
import retrofit2.http.*

interface DicioApi {


    @GET("/v1/sec_dev_interview")
    suspend fun getUsers(
        @Header("xc-token") auth: String = "J38b4XQNLErVatKIh4oP1jw9e_wYWkS86Y04TMNP",
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Host") host: String = "api.devdicio.net",
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 25,
    ): List<User>

    @POST("/v1/sec_dev_interview")
    suspend fun saveUser(
        @Header("xc-token") auth: String = "J38b4XQNLErVatKIh4oP1jw9e_wYWkS86Y04TMNP",
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Host") host: String = "api.devdicio.net",
        @Body body: UserOut
    )
}