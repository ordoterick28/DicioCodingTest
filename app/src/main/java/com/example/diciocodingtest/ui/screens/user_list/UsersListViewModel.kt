package com.example.diciocodingtest.ui.screens.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.diciocodingtest.domain.model.User
import com.example.diciocodingtest.domain.uses_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor (
    private val useCases: UseCases
): ViewModel() {

    private val _userList
            = MutableStateFlow<PagingData<User>>(PagingData.empty())
    val userList = _userList

    val TAGS = "UsersListViewModel"

    init {
        getUsers()
    }

    private fun getUsers() {
        try {
            viewModelScope.launch {
                useCases.getUsersUCase.invoke().cachedIn(viewModelScope).collect {
                    _userList.value = it
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}