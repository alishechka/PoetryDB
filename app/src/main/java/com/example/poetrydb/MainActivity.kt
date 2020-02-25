package com.example.poetrydb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poetrydb.adapter.AuthorAdapter
import com.example.poetrydb.network.PoetryRepositoryImpl
import com.example.poetrydb.viewModel.PoetryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this, PoetryViewModelFactory(PoetryRepositoryImpl()))
            .get(PoetryViewModel::class.java)

        viewModel.getRepoPoetryByAuth("author")

        viewModel.authorLiveDataSuccess.observe(this, Observer {
            rv_display.adapter = AuthorAdapter(it, this)
            rv_display.layoutManager = LinearLayoutManager(this)

        })


//        et_search.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//
//                viewModel.getRepoPoetryByAuth(s.toString())
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//        })



    }

    override fun clickedItem(s: String) {
        val intent = Intent(this, PoemActivity::class.java)
//        intent.putExtra(AUTHOR_NAME,s)
        TEST_VAL = s
        startActivity(intent)
    }
}
