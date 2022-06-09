package com.example.todoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.FragmentDetailsBinding
import com.example.todoapp.models.Event


class DetailsFragment : Fragment(){

    //set up binding and eventAdapter by lazy
    private val binding by lazy{
        FragmentDetailsBinding.inflate(layoutInflater)
    }



    // Event object that will hold the incoming data
    private lateinit var newEvent: Event

    //newEvent is being set to data coming in from click event in main fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newEvent= it.getSerializable(MainFragment.EVENT_DATA) as Event
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        //mapping the text fields in the xml file to the incoming data

        binding.eventNameDetails.text=newEvent.name
        binding.eventCategoryDetails.text = newEvent.category
        binding.eventDateDetails.text = newEvent.date

        return binding.root
    }













}