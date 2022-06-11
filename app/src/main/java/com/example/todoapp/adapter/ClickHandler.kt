package com.example.todoapp.adapter

import com.example.todoapp.models.Event

interface ClickHandler {

    fun onEventItemClick(event: Event)


}