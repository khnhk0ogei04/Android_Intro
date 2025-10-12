package com.example.slider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

data class Slide(
    val title: String,
    val imageResId: Int
)
class SliderAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    private val slides = listOf(
        Slide("Image 1", R.drawable.image1),
        Slide("Image 2", R.drawable.image2),
        Slide("Image 3", R.drawable.image3)
    )

    override fun getItemCount(): Int {
        return slides.size
    }

    override fun createFragment(position: Int): Fragment {
        val slide = slides[position]
        return SlideFragment.newInstance(slide.title, slide.imageResId)
    }
}