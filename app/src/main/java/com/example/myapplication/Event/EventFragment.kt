package com.example.myapplication.Event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class EventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.event_list)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val eventDataManager = EventDataManager()

        val dataList = eventDataManager.loadEventData(resources)

        val adapter = EventAdapter(dataList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : EventAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val currentItem = dataList[position]
                navigateToOtherFragment(currentItem)
            }
        })

        return view
    }

    private fun navigateToOtherFragment(currentItem: EventData) {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        // Замените "YourOtherFragment" на имя вашего другого фрагмента
        val otherFragment = EventDetailFragment.newInstance(
            currentItem.imageResource,
            currentItem.title,
            currentItem.desc,
            currentItem.status
        )

        // Добавьте к транзакции операции для замены текущего фрагмента на другой
        transaction.replace(R.id.fragment_container, otherFragment)
        transaction.addToBackStack(null)  // Добавьте в стек, чтобы можно было вернуться

        // Примените транзакцию
        transaction.commit()
    }

}
