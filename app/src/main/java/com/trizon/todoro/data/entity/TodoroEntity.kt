package com.trizon.todoro.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "todoro_table")
data class TodoroEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val title: String?,
    val description: String?
) : Parcelable


