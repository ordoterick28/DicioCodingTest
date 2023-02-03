package com.example.diciocodingtest.data.repository

import androidx.paging.PagingData
import com.example.diciocodingtest.domain.model.User
import com.example.diciocodingtest.domain.model.UserOut
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource
) {
    val TAGS = "Repository"

    fun getUsers(): Flow<PagingData<User>> {
        return remote.getUsers()
    }

    suspend fun saveUser(user: UserOut) {
        return remote.saveUserX(user)
    }

}