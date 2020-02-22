package com.example.poetrydb.model

import com.google.gson.annotations.SerializedName

//is a List
data class TitleByAuthorModel(
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("lines") val lines: List<String>,
    @SerializedName("linecount") val linecount: Int
)