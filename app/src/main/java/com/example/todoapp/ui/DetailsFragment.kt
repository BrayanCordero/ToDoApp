package com.example.todoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.adapter.ClickHandler
import com.example.todoapp.databinding.FragmentDetailsBinding
import com.example.todoapp.models.Event


class DetailsFragment : Fragment() {

    private val binding by lazy{
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    //Let events be null if there are no event object to populate the view.
    private var newEvent: Event?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newEvent= it.getSerializable(EntryFragment.EVENT_DATA) as? Event
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return binding.root
    }



}