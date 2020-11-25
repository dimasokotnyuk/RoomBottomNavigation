package com.example.roombottomnavigation.adapters.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.interfaces.OnUserClickListener
import com.example.roombottomnavigation.room.Student
import com.example.roombottomnavigation.room.StudentWithGroup

class ViewHolderStudent(
    private val listItemView: View,
    private val listener: OnUserClickListener,
    private val callback: (StudentWithGroup) -> Unit
) : RecyclerView.ViewHolder(listItemView) {

    fun bindStudent(item: StudentWithGroup) {
        listItemView.findViewById<TextView>(R.id.tvFirstName).text = item.student.firstName
        listItemView.findViewById<TextView>(R.id.tvLastName).text = item.student.lastName
        listItemView.findViewById<TextView>(R.id.tvFaculty).text = item.student.faculty
        listItemView.findViewById<TextView>(R.id.tvGroup).text = item.group.nameGroup
        listItemView.findViewById<TextView>(R.id.tvUniversity).text = item.student.university
        listItemView.findViewById<ImageView>(R.id.ivAvatar).apply {
            Glide
                .with(context)
                .load("https://picsum.photos/200/300?random=2")
                .centerCrop()
                .into(this)
        }

        listItemView.setOnClickListener {
//            listener.onUserClick(item)
//            callback(item) // тоже самое  callback.invoke(item)
            callback.invoke(item)
        }
    }
}