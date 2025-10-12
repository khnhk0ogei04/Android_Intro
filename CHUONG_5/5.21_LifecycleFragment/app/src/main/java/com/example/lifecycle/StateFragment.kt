package com.example.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lifecycle.databinding.FragmentStateBinding

private const val KEY_SAVED_TEXT = "savedText"

/**
 * A simple [Fragment] subclass.
 * Use the [StateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StateFragment : Fragment() {
    private var _binding: FragmentStateBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("StateFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("StateFragment", "onCreate; restored? ${savedInstanceState != null}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            binding.btnSave.setOnClickListener{
                Toast.makeText(
                    context, "Text saved: ${binding.editTextInput.text}", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_SAVED_TEXT, binding.editTextInput.text.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}