package com.example.myapplication.Event

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.R.id

class EventDetailFragment : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event_detail, container, false)

        val imageResource = arguments?.getInt(ARG_IMAGE_RESOURCE, 0) ?: 0
        val title = arguments?.getString(ARG_TITLE) ?: ""
        val desc = arguments?.getString(ARG_DESC) ?: ""
        val status = arguments?.getString(ARG_STATUS) ?: ""

        val imgView: ImageView = view.findViewById(R.id.main_img_event)
        val titleText: TextView = view.findViewById(R.id.title_detile_event)
        val descText: TextView = view.findViewById(R.id.main_text_event)

        imgView.setImageResource(imageResource)
        titleText.text = title
        descText.text = desc

        return view
    }

    companion object {
        private const val ARG_IMAGE_RESOURCE = "imageResources"
        private const val ARG_TITLE = "title"
        private const val ARG_DESC = "desc"
        private const val ARG_STATUS = "status"

        fun newInstance(imageResource: Int, title: String, desc: String, status: String): EventDetailFragment {
            val fragment = EventDetailFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_RESOURCE, imageResource)
            args.putString(ARG_TITLE, title)
            args.putString(ARG_DESC, desc)
            args.putString(ARG_STATUS, status)
            fragment.arguments = args
            return fragment
        }
    }

}