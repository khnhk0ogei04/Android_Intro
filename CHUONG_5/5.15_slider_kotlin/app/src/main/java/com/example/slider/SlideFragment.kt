package com.example.slider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SlideFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SlideFragment : Fragment() {
    companion object {
        private const val KEY_TITLE = "TITLE"
        private const val KEY_IMAGE_RES_ID = "IMAGE_RES_ID"
        fun newInstance(title: String, imageResId: Int) = SlideFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_TITLE, title)
                putInt(KEY_IMAGE_RES_ID, imageResId)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_slide, container, false)

        val textView = view.findViewById<TextView>(R.id.textViewTitle)
        val imageView = view.findViewById<ImageView>(R.id.imageViewSlide)

        val title = arguments?.getString(KEY_TITLE) ?: "Untitled"
        val imgRes = arguments?.getInt(KEY_IMAGE_RES_ID) ?: R.drawable.ic_launcher_background

        textView.text = title
        imageView.setImageResource(imgRes)
        return view
    }
}