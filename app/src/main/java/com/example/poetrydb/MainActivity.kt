package com.example.poetrydb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poetrydb.adapter.AuthorAdapter
import com.example.poetrydb.viewModel.PoetryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(PoetryViewModel::class.java)
        viewModel.getRepoPoetryByAuth()

        viewModel.authorLiveDataSuccess.observe(this, Observer {
            rv_display.adapter = AuthorAdapter(it, this)
            rv_display.layoutManager = LinearLayoutManager(this)
        })
        viewModel.authorLiveDataError.observe(this, Observer {
            test_text.text=it
        })

    }

    override fun clickedItem(s: String) {
        val intent = Intent(this, PoemActivity::class.java)
        intent.putExtra(AUTHOR_NAME,s)
        TEST_VAL = s
        startActivity(intent)
    }
}
