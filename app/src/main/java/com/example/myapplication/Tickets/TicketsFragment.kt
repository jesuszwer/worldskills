package com.example.myapplication.Tickets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class TicketsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tickets, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.ticket_list)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val dataList = listOf(
            TicketData("John", "A10 Row1 Column1", 0)
        )

        val adapter = TicketsAdapter(dataList)
        recyclerView.adapter = adapter

        return view
    }
}