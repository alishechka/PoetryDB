package com.example.poetrydb.network

import com.example.poetrydb.TEST_VAL
import com.example.poetrydb.model.AuthorModel
import com.example.poetrydb.model.TitleByAuthorModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PoetryRepositoryImpl : PoetryRepository {
    private val client = PoetryRetrofitClient.getRetrofitInstance
//    private val callAuthor = client.getByAuthor()

    private val callTitleByAuthor = client.getTitleByAuthor(TEST_VAL)

    override fun getPoetryAuthData(typedAuthorString: String): Observable<AuthorModel> {
        return client.getByAuthor(typedAuthorString).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTitleByAuthor(): Observable<List<TitleByAuthorModel>> {
        return callTitleByAuthor.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}