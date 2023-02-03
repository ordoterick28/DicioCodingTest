package com.example.diciocodingtest.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.diciocodingtest.data.remote.DicioApi
import com.example.diciocodingtest.domain.model.User

const val NETWORK_PAGE_SIZE = 25
private const val INITIAL_LOAD_SIZE = 0
const val END_OF_PAGINATION = 300

class UserPagingSource(
    private val api: DicioApi
): PagingSource<Int, User>()  {

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, User> {
        return try {

            val position = params.key ?: 0
            val offset = if (params.key != null) {
                ((position - 1) * NETWORK_PAGE_SIZE)
            } else {
                INITIAL_LOAD_SIZE
            }

            val responseData = mutableListOf<User>()
            val currentPage = params.key ?: 1
            if(offset < END_OF_PAGINATION){
                val response = api.getUsers(offset = offset)
                responseData.addAll(response)
            }
            if (responseData.isNotEmpty()) {
                LoadResult.Page(
                    data = responseData,
                    prevKey = if (currentPage == 1) null else -1,
                    nextKey = currentPage.plus(1)
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }
}