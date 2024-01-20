package com.example.myapplication.Event

import android.content.res.Resources
import com.example.myapplication.R
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset

class EventDataManager {
    fun loadEventData(resources: Resources): List<EventData> {
        val dataList = mutableListOf<EventData>()

        try {
            val inputStream = resources.openRawResource(R.raw.events_data)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val jsonString = String(buffer, Charset.defaultCharset())

            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val jsonObject: JSONObject = jsonArray.getJSONObject(i)
                val eventTitle = jsonObject.getString("eventTitle")
                val eventText = jsonObject.getString("eventText")

                // Создаем EventData с Unread статусом
                val eventData = EventData(R.drawable.ic_img, eventTitle, eventText, "Unread")
                dataList.add(eventData)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return dataList
    }
}