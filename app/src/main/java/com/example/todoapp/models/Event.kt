package com.example.todoapp.models

import java.io.Serializable

data class Event(

    val name: String,
    val category: String,
    val date: String,
    val milliDate : Long

):Serializable

