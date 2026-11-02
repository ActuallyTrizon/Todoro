package com.trizon.todoro.data.remote

import com.trizon.todoro.data.model.TodoroModel
import retrofit2.Response
import retrofit2.http.*

interface AppApi {

    @GET("/api/v1/todoro")
    suspend fun getTodoroResult(): Response<List<TodoroModel>>

}