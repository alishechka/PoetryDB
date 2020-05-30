package com.example.poetrydb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poetrydb.adapter.TitleByAuthorAdapter
import com.example.poetrydb.viewModel.TitleByAuthorViewModel
import kotlinx.android.synthetic.main.activity_poem.*

class PoemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poem)

//        val viewModel = ViewModelProvider(this).get(TitleByAuthorViewModel::class.java)
//        viewModel.getRepoTitleByAuthor()
//        viewModel.titleLiveDataSuccess.observe(this, Observer {
//            rv_title_by_Author.adapter = TitleByAuthorAdapter(it)
//            rv_title_by_Author.layoutManager = LinearLayoutManager(this)
//        })

    }
}
