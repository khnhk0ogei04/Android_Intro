package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment = when (position){
        0 -> HomeFragment()
        1 -> ProfileFragment()
        2 -> SettingsFragment()
        else -> {
            HomeFragment()
        }
    }

}