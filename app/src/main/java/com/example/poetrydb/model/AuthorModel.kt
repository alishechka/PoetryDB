package com.example.poetrydb.model

import com.google.gson.annotations.SerializedName

class AuthorModel (
    @SerializedName("authors") val authors : List<String>
)