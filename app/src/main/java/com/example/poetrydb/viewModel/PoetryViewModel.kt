package com.example.poetrydb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poetrydb.model.AuthorModel
import com.example.poetrydb.network.PoetryRepository
import com.example.poetrydb.network.PoetryRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class PoetryViewModel(val poetRepo:PoetryRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
//    private val poetRepo = PoetryRepositoryImpl().getPoetryAuthData()
    val authorLiveDataSuccess = MutableLiveData<AuthorModel>()
    val authorLiveDataError = MutableLiveData<String>()

    fun getRepoPoetryByAuth(s:String) {
        compositeDisposable.add(
            poetRepo.getPoetryAuthData(s)
                .subscribe({ i -> authorLiveDataSuccess.value = i }
                    , { e -> authorLiveDataError.value = e.message })
        )

    }


}