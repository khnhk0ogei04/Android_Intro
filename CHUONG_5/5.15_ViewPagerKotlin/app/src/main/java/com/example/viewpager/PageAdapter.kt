package com.example.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    private val pages = listOf("Welcome", "Features", "Get Started")

    override fun getItemCount(): Int {
        return pages.size
    }

    override fun createFragment(position: Int): Fragment {
        return PageFragment.newInstance(pages[position])
    }
}