package com.example.diciocodingtest.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.diciocodingtest.data.remote.DicioApi
import com.example.diciocodingtest.data.remote.paging.UserPagingSource
import com.example.diciocodingtest.domain.model.User
import com.example.diciocodingtest.domain.model.UserOut
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSource @Inject constructor (
    private val dicioApi: DicioApi,
){
    val TAGS = "RemoteDataSource"

    fun getUsers(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            pagingSourceFactory = {
                UserPagingSource(api = dicioApi)
            }
        ).flow
    }

    suspend fun saveUserX(user: UserOut) {
        dicioApi.saveUser(body = user)
    }

}