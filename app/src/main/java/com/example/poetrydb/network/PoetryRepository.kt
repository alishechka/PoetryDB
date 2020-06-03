package com.example.poetrydb.network

import com.example.poetrydb.model.AuthorModel
import com.example.poetrydb.model.TitleByAuthorModel
import io.reactivex.Observable

interface PoetryRepository {

    fun getPoetryAuthData(): Observable<AuthorModel>
    fun getTitleByAuthor(author:String): Observable<List<TitleByAuthorModel>>
}