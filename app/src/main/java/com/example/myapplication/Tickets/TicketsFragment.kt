package com.example.myapplication.Tickets

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Event.EventAdapter
import com.example.myapplication.Event.EventDetailFragment
import com.example.myapplication.Event.TicketsDetailFragment
import com.example.myapplication.R

class TicketsFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
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

        adapter.setOnItemClickListener(object : TicketsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                navigateToOtherFragment()
            }
        })

        val createButton: Button = view.findViewById(R.id.create_button)
        createButton.setOnClickListener {
            handleCreateButtonClick()
        }

        return view
    }

    private fun navigateToOtherFragment() {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        // Замените "YourOtherFragment" на имя вашего другого фрагмента
        val otherFragment = TicketsDetailFragment()

        // Добавьте к транзакции операции для замены текущего фрагмента на другой
        transaction.replace(R.id.fragment_container, otherFragment)
        transaction.addToBackStack(null)  // Добавьте в стек, чтобы можно было вернуться

        // Примените транзакцию
        transaction.commit()
    }

    private fun handleCreateButtonClick() {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val ticketsCreateFragment = TicketsCreateFragment()

        // Замените R.id.fragment_container на идентификатор вашего контейнера для фрагментов
        transaction.replace(R.id.fragment_container, ticketsCreateFragment)
        transaction.addToBackStack(null)  // Добавьте в стек, чтобы можно было вернуться

        transaction.commit()
    }

}