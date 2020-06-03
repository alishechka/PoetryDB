package com.example.poetrydb.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poetrydb.model.TitleByAuthorModel
import com.example.poetrydb.network.PoetryRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class TitleByAuthorViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
//    private val titleRepo = PoetryRepositoryImpl().getTitleByAuthor()
    val titleLiveDataSuccess = MutableLiveData<List<TitleByAuthorModel>>()
    val titleLiveDataError = MutableLiveData<String>()


    fun getRepoTitleByAuthor(author:String) {
        compositeDisposable.add(
            PoetryRepositoryImpl().getTitleByAuthor(author).subscribe({ i ->
                titleLiveDataSuccess.value = i
            }, { e -> titleLiveDataError.value = e.message })
        )
    }


}