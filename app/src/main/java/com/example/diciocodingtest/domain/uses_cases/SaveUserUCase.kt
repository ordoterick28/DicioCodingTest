package com.example.diciocodingtest.domain.uses_cases


import com.example.diciocodingtest.data.repository.Repository
import com.example.diciocodingtest.domain.model.UserOut
import javax.inject.Inject

class SaveUserUCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(user: UserOut) {
        return repository.saveUser(user)
    }
}