package com.trizon.todoro.domain.usecase

import com.trizon.todoro.data.model.TodoroModel
import com.trizon.todoro.data.model.Resource
import com.trizon.todoro.data.repository.TodoroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodorosUseCase @Inject constructor(
    private val todoroRepository: TodoroRepository,
) {
    operator fun invoke(): Flow<Resource<List<TodoroModel>>> = todoroRepository.getTodoros()
}
