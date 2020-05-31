package com.example.poetrydb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poetrydb.model.AuthorModel
import com.example.poetrydb.network.PoetryRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class AuthorViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val poetRepo = PoetryRepositoryImpl().getPoetryAuthData()
    val authorLiveDataSuccess = MutableLiveData<AuthorModel>()
    val authorLiveDataError = MutableLiveData<String>()

//    fun getData(): MutableLiveData<AuthorModel> {
//        return authorLiveDataSuccess
//    }

    fun getRepoPoetryByAuth() {
        compositeDisposable.add(
            poetRepo
                .subscribe({ i -> authorLiveDataSuccess.value = i }
                    , { e -> authorLiveDataError.value = e.message })
        )

    }


}