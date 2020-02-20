package com.example.poetrydb.network

import com.example.poetrydb.model.AuthorModel
import com.example.poetrydb.network.PoetryRepository
import com.example.poetrydb.network.PoetryRetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PoetryRepositoryImpl : PoetryRepository {
    private val client = PoetryRetrofitClient.getRetrofitInstance
    private val call = client.getByAuthor()

    override fun getPoetryAuthData(): Observable<AuthorModel> {
        return call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}