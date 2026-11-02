package com.trizon.todoro.data.dao

import androidx.room.*
import com.trizon.todoro.data.entity.TodoroEntity

@Dao
interface TodoroDao {

    @Query("SELECT * FROM todoro_table")
    fun getTodoroData(): List<TodoroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(search: TodoroEntity)

    @Update
    suspend fun update(search: TodoroEntity)

    @Delete
    suspend fun delete(search: TodoroEntity)

}