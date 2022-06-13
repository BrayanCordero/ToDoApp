package com.example.todoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.EventTodoBinding
import com.example.todoapp.models.Event



class EventAdapter(

    // click handling with interface
    private val onEventClickHandler: ClickHandler,
    private val eventList: MutableList<Event> = Singleton.eventList,


    // click handling with high order function
    private val onClickEventHighOrderFunction: (Event) -> Unit
) : RecyclerView.Adapter<EventViewHolder>() //logic for the Recycler view
{
    //function that takes in an Event and updates the view when a new event is added
    fun updateEventList(event: Event){
//        eventList.add(event)
        notifyItemInserted(sortedDate(event).indexOf(event))

    }

    fun sortedDate(event: Event): List<Event>{
        eventList.add(event)
        var sortedList = eventList.sortedBy {it.milliDate}
        Singleton.eventList.clear()
        println(sortedList)
        sortedList.forEach{Singleton.eventList.add(it)}
        println(Singleton.eventList)
        notifyItemInserted(sortedList.indexOf(event))
        return sortedList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder =
        EventViewHolder(
            //ToDoItemBinding from event_todo.xml
            EventTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        override fun onBindViewHolder(holder: EventViewHolder, position: Int) =
            holder.bind(eventList[position], onEventClickHandler, onClickEventHighOrderFunction)

        override fun getItemCount(): Int = eventList.size

}


//this class is getting user input and binding it to the model. two ways to handle the click
//EventTodoBinding comes from event_todo.xml
class EventViewHolder(
    private val binding: EventTodoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        event: Event, onEventClickHandler: ClickHandler, onClickEventHighOrderFunction: (Event) -> Unit
    ) {
        binding.eventName.text = event.name
        binding.eventCategory.text = event.category
        binding.eventDate.text = event.date

        itemView.setOnClickListener {
            // this is handling the click with interface
            // onEventClickHandler.onEventItemClick(event)

            // this is handling click with high order function
            onClickEventHighOrderFunction(event)
        }
    }
}

//sorting list by date
//class CompareDate(event: Event?): Comparator<Event?> {
//    override fun compare(o1: Event?, o2: Event?): Int {
//        if(o1 == null || o2 == null){
//            return 0;
//        }
//        return o1.date.compareTo(o2.date)
//    }
//}



