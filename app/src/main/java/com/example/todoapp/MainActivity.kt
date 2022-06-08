package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Need to create private val to use binding
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root) // change this to binding.root

        val navController = findNavController(R.id.nav_container_fragment) //id for fragment in activity_main.xml
        binding.navigationBar.setupWithNavController(navController) // bar in activity_main.xml
    }
}


//first need to add all the files needed for the app
//UI,Models,Adapter,Menu,Navigation
// navigation allows you to move from one fragment to another
//Then do activity_main.xml and come back and add navController
//Do menu and add it to activity_main.xml inside the BottomNavigationView
//Do fragment_main.xml , then fragment_entry.xml , then fragment_details.xml
//Add a new layout for the events list todoItems
//Next the logic for fragments; MainFragment, EntryFragment, and DetailsFragment
//and the logic for ClickHandler and EventAdapter