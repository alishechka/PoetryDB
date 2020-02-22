package com.example.poetrydb.model

import com.google.gson.annotations.SerializedName

data class AuthorModel (
    @SerializedName("authors") val authors : List<String>
)