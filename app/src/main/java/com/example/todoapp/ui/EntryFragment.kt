package com.example.todoapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentEntryBinding
import com.example.todoapp.models.Event


class EntryFragment : Fragment() {

    private val binding by lazy {
        FragmentEntryBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.eventNameEntry.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // no-op right now
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.eventSaveBtn.isEnabled = p0?.isNotEmpty() ?: false
            }

            override fun afterTextChanged(p0: Editable?) {
                // no-op right now
            }

        })

        binding.eventSaveBtn.setOnClickListener {


            val name = binding.eventNameEntry.text.toString()
            val category = binding.eventCategoryEntry.text.toString()
            val date = binding.eventCalendar.date.toString()

            Event(name, category, date).also {
                findNavController().navigate(
                    R.id.action_entryFragment_to_mainFragment, bundleOf(
                    Pair(EVENT_DATA, it)
                ))
            }
        }

        return binding.root
    }

    companion object {
        const val EVENT_DATA = "EVENT_DATA"
    }
}