package com.example.zodiac.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.zodiac.R
import com.example.zodiac.databinding.FragmentZodiacBinding
import com.example.zodiac.databinding.FragmentZodiacItemBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ZodiacItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ZodiacItemFragment : Fragment() {
    private var _binding: FragmentZodiacItemBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val BUNDLE_KEY_DRAWABLE_ID = "com.example.drawableId"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentZodiacItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImageFromArgs()
    }

    private fun loadImageFromArgs(){
        val drawableId = arguments?.getInt(BUNDLE_KEY_DRAWABLE_ID)
        if (drawableId != null) {
            Glide.with(this).load(drawableId)
                .error(R.drawable.dragon).into(binding.image)
        }
    }
}