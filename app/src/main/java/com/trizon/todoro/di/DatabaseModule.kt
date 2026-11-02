package com.trizon.todoro.di

import android.app.Application
import androidx.room.Room
import com.trizon.todoro.data.dao.TodoroDao
import com.trizon.todoro.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: AppDatabase.Callback): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "local_database")
            .fallbackToDestructiveMigration(dropAllTables = true)
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideTodoroDao(database: AppDatabase): TodoroDao {
        return database.getTodoroDao()
    }
}