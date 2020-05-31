package com.example.poetrydb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.poetrydb.fragment.AuthorFragment
import com.example.poetrydb.fragment.TestFragment2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test_text.text = "this works main"


        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "by Author"
                1 -> tab.text = "by Poem"
            }
        }.attach()
    }

    private inner class ScreenSlidePagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 2 //because I have two Fragments

        override fun createFragment(position: Int): Fragment = if (position == 0) {
            AuthorFragment()
        } else {
            TestFragment2()
        }
    }

//    override fun clickedItem(s: String) {
//        val intent = Intent(this, PoemActivity::class.java)
//        intent.putExtra(AUTHOR_NAME, s)
//        TEST_VAL = s
//        startActivity(intent)
//    }
}
