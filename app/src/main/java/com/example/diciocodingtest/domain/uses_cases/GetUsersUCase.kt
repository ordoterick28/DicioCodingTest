package com.example.diciocodingtest.domain.uses_cases

import androidx.paging.PagingData
import com.example.diciocodingtest.data.repository.Repository
import com.example.diciocodingtest.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<User>> {
        return repository.getUsers()
    }

}