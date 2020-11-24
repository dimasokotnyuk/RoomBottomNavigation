package com.example.roombottomnavigation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.roombottomnavigation.room.Student

class DiffUtilStudent(
    private val oldList: List<Student>,
    private val newList: List<Student>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPos: Int, newItemPos: Int): Boolean {
        return oldList[oldItemPos].id == newList[newItemPos].id
    }

    override fun areContentsTheSame(oldItemPos: Int, newItemPos: Int): Boolean {
        return oldList[oldItemPos] == newList[newItemPos]
    }
}