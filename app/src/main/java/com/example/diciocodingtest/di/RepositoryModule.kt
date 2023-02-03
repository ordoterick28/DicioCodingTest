package com.example.diciocodingtest.di


import com.example.diciocodingtest.data.repository.Repository
import com.example.diciocodingtest.domain.uses_cases.GetUsersUCase
import com.example.diciocodingtest.domain.uses_cases.SaveUserUCase
import com.example.diciocodingtest.domain.uses_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveUserUCase = SaveUserUCase(repository),
            getUsersUCase = GetUsersUCase(repository),
        )
    }


}