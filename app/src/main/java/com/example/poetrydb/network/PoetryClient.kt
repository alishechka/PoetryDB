package com.example.poetrydb.network

import com.example.poetrydb.END_POINT_AUTHOR
import com.example.poetrydb.model.AuthorModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PoetryClient {

    @GET(END_POINT_AUTHOR)
    fun getByAuthor(): Observable<AuthorModel>
}