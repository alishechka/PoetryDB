package com.example.poetrydb.network

import com.example.poetrydb.AUTHOR_NAME
import com.example.poetrydb.TEST_VAL
import com.example.poetrydb.model.AuthorModel
import com.example.poetrydb.model.TitleByAuthorModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PoetryRepositoryImpl : PoetryRepository {
    private val client = PoetryRetrofitClient.getRetrofitInstance
    private val callAuthor = client.getByAuthor()

    private val callTitleByAuthor = client.getTitleByAuthor(AUTHOR_NAME)

    override fun getPoetryAuthData(): Observable<AuthorModel> {
        return callAuthor.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTitleByAuthor(author:String): Observable<List<TitleByAuthorModel>> {
        return client.getTitleByAuthor(author).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}