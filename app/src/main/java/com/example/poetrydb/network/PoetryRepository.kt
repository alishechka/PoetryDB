package com.example.poetrydb.network

import com.example.poetrydb.model.AuthorModel
import io.reactivex.Observable

interface PoetryRepository {

    fun getPoetryAuthData():Observable<AuthorModel>
}