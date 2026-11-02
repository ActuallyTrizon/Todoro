package com.trizon.todoro.data.model

import com.google.gson.annotations.SerializedName

data class TodoroModel(
    @SerializedName("title")
    var title: String?,
    @SerializedName("description")
    var description: String?
)
