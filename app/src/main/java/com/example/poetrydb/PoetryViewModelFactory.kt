package com.example.poetrydb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.poetrydb.network.PoetryRepository
import com.example.poetrydb.viewModel.PoetryViewModel

class PoetryViewModelFactory(private val repository: PoetryRepository) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PoetryViewModel(repository) as T
    }
}