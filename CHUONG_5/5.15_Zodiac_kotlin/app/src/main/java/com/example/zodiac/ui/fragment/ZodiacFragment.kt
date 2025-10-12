package com.example.zodiac.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zodiac.R
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.zodiac.databinding.FragmentZodiacBinding
import com.example.zodiac.ui.ZodiacViewModel
import com.example.zodiac.ui.adapter.ZodiacPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

/**
 * A simple [Fragment] subclass.
 * Use the [ZodiacFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ZodiacFragment : Fragment() {
    private var _binding: FragmentZodiacBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ZodiacPagerAdapter
    private var mediator: TabLayoutMediator? = null

    private val viewModel: ZodiacViewModel = ViewModelProvider(this)[ZodiacViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentZodiacBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ZodiacPagerAdapter(this)
        binding.apply {
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = adapter.getTitle(position)
            }.attach()
        }

        viewModel.zodiacs.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}