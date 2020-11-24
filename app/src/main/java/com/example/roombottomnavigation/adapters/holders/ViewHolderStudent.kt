package com.example.roombottomnavigation.adapters.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.adapters.AdapterStudent
import com.example.roombottomnavigation.fragments.FragmentNewName
import com.example.roombottomnavigation.room.Student
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_student.*

class ViewHolderStudent(private val listItemView: View) : RecyclerView.ViewHolder(listItemView) {

    fun bindStudent(item: Student) {
        listItemView.findViewById<TextView>(R.id.tvFirstName).text = item.firstName
        listItemView.findViewById<TextView>(R.id.tvLastName).text = item.lastName
        listItemView.findViewById<TextView>(R.id.tvFaculty).text = item.faculty
        listItemView.findViewById<TextView>(R.id.tvGroup).text = item.group
        listItemView.findViewById<TextView>(R.id.tvUniversity).text = item.university
    }
}