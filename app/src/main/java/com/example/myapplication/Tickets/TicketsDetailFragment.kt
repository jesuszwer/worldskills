package com.example.myapplication.Event

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.Tickets.TicketsCreateFragment

class TicketsDetailFragment : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tickets_detail, container, false)

        val createbutton : Button = view.findViewById(R.id.create_btn)

        createbutton.setOnClickListener {
            handleCreateButtonClick()
        }

        return view
    }

    private fun handleCreateButtonClick() {
        print("Create a new tickets")
    }

}