package com.example.todoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.adapter.ClickHandler
import com.example.todoapp.adapter.EventAdapter
import com.example.todoapp.databinding.FragmentMainBinding
import com.example.todoapp.models.Event


class MainFragment : Fragment(), ClickHandler {

    //set up binding and eventAdapter by lazy
    private val binding by lazy{
        FragmentMainBinding.inflate(layoutInflater)
    }

    //Navbar home icon will direct to mainFragment?
    private val eventAdapter by lazy{
        EventAdapter(this){
            event-> findNavController().navigate(
            R.id.action_mainFragment_to_detailsFragment,
            bundleOf(Pair(EntryFragment.EVENT_DATA,event))
            )
        }
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
        binding.todoRecycler.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false)
            adapter = eventAdapter
        }

        binding.createEvent.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_entryFragment)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        newEvent?.let {
            eventAdapter.updateEventList(it)
            newEvent = null
            arguments = null
        }
    }

    // when user clicks on an item it will navigate to details fragment
    override fun onEventItemClick(event: Event) {
        findNavController().navigate(
            R.id.action_mainFragment_to_detailsFragment,
            bundleOf(Pair(EntryFragment.EVENT_DATA, event))
        )
    }





}