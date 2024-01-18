package com.example.myapplication.Records

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecordsFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_records, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.record_list)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val dataList = mutableListOf<RecordData>()

        // Populate dataList with records from "Audio 1" to "Audio 10"
        for (i in 1..10) {
            dataList.add(RecordData("Audio $i"))
        }

        val adapter = RecordAdapter(dataList)
        recyclerView.adapter = adapter

        return view
    }

}