package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TicketsFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tickets, container, false)
        var recyclerView: RecyclerView = view.findViewById(R.id.open_list)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val namesList = arrayOf("John", "Alian","Eldar")

        var dataList = listOf(
            TicketData(namesList.random().toString(), "A10 Row2 Column10"),
            TicketData(namesList.random().toString(), "A10 Row2 Column10"),
            TicketData(namesList.random().toString(), "A10 Row2 Column10")
        )

        var adapter = TicketsAdapter(dataList)
        recyclerView.adapter = adapter

        recyclerView = view.findViewById(R.id.close_list)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        dataList = listOf(
            TicketData(namesList.random().toString(), "A11 Row2 Column10"),
            TicketData(namesList.random().toString(), "A12 Row2 Column10"),
            TicketData(namesList.random().toString(), "A13 Row2 Column10")
        )

        adapter = TicketsAdapter(dataList)
        recyclerView.adapter = adapter


        return view
    }
}