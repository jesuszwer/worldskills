package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.event_list)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val dataList = listOf(
            EventData(R.drawable.ic_events,
                "Event 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Integer velmolestie felis. Vivamus sed lacinia elit. " +
                        "Suspendisse tristique bibendum eros in elementum",
                "Unread")
        )

        val adapter = EventAdapter(dataList)
        recyclerView.adapter = adapter

        return view
    }
}
