package com.trizon.todoro.data.repository

import com.trizon.todoro.data.dao.TodoroDao
import com.trizon.todoro.data.model.TodoroModel
import com.trizon.todoro.data.model.Resource
import com.trizon.todoro.data.remote.AppApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoroRepository @Inject constructor(
    private val appApi: AppApi,
    private val todoroDao: TodoroDao,
) {

    fun getTodoros(): Flow<Resource<List<TodoroModel>>> = flow {
        emit(Resource.Loading)
        try {
            val response = appApi.getTodoroResult()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                emit(Resource.Success(body))
            } else {
                emit(Resource.Error("Request failed with code ${response.code()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown network error"))
        }
    }
}
