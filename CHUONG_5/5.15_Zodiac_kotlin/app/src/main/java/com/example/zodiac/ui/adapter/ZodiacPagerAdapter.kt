package com.example.zodiac.ui.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.zodiac.data.model.Zodiac
import com.example.zodiac.ui.fragment.ZodiacItemFragment

class ZodiacPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    private val items = mutableListOf<Zodiac>()

    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int): Fragment {
        val frag = ZodiacItemFragment()
        val resId = items[position].drawableId
        frag.arguments = bundleOf(ZodiacItemFragment.BUNDLE_KEY_DRAWABLE_ID to resId)
        return frag
    }

    fun submitList(newList: List<Zodiac>){
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
    fun getTitle(position: Int): String {
        return items[position].name
    }
}