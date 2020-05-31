package com.example.poetrydb.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poetrydb.R
import com.example.poetrydb.adapter.AuthorAdapter
import com.example.poetrydb.onItemClick
import com.example.poetrydb.viewModel.AuthorViewModel
import kotlinx.android.synthetic.main.fragment_author.*

class AuthorFragment : Fragment(), onItemClick {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_author, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel =ViewModelProvider(this).get(AuthorViewModel::class.java)
        viewModel.getRepoPoetryByAuth()

        viewModel.authorLiveDataSuccess.observe(viewLifecycleOwner, Observer {
            rv_by_author.adapter=AuthorAdapter(it,this)
            rv_by_author.layoutManager=LinearLayoutManager(activity)
        })
    }
    override fun clickedItem(s: String) {
//        val intent = Intent(this, PoemActivity::class.java)
//        intent.putExtra(AUTHOR_NAME, s)
//        TEST_VAL = s
//        startActivity(intent)
        Log.i("Fragment",s)
    }
}
