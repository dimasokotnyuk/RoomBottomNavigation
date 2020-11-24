package com.example.roombottomnavigation.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.adapters.holders.ViewHolderFaculty
import com.example.roombottomnavigation.adapters.holders.ViewHolderUniversity
import com.example.roombottomnavigation.room.Faculty
import com.example.roombottomnavigation.room.University

class AdapterUniversity : RecyclerView.Adapter<ViewHolderUniversity>() {

    var dataUniversity: MutableList<University> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUniversity {
        return ViewHolderUniversity(
            LayoutInflater.from(parent.context).inflate(R.layout.item_university, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderUniversity, position: Int) {
        holder.bindUniversity(dataUniversity[position])
    }

    override fun getItemCount(): Int {
        return dataUniversity.size
    }
}