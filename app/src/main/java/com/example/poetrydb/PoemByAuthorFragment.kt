package com.example.poetrydb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poetrydb.adapter.TitleByAuthorAdapter
import com.example.poetrydb.viewModel.TitleByAuthorViewModel
import kotlinx.android.synthetic.main.fragment_poem_by_author.*

class PoemByAuthorFragment : Fragment() {
    lateinit var author: String
    //for displaying poems as per author clicked

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poem_by_author, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        if (bundle != null) {
            author = bundle.get(AUTHOR_NAME).toString()
        }
        val viewModel = ViewModelProvider(this).get(TitleByAuthorViewModel::class.java)

        viewModel.getRepoTitleByAuthor(author)
        viewModel.titleLiveDataSuccess.observe(viewLifecycleOwner, Observer {
            rv_title_by_Author.adapter = TitleByAuthorAdapter(it)
            rv_title_by_Author.layoutManager = LinearLayoutManager(activity)
        })

    }

}
