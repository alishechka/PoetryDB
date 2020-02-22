package com.example.poetrydb.network

import com.example.poetrydb.END_POINT_AUTHOR
import com.example.poetrydb.model.AuthorModel
import com.example.poetrydb.model.TitleByAuthorModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PoetryClient {
    //is an Object
    @GET(END_POINT_AUTHOR)
    fun getByAuthor(): Observable<AuthorModel>

    //is a List
    @GET(END_POINT_AUTHOR + "/{author}")
    fun getTitleByAuthor(@Path("author") author: String): Observable<List<TitleByAuthorModel>>
}