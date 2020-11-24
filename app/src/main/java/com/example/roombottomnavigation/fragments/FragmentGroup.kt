package com.example.roombottomnavigation.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.adapters.AdapterGroup
import com.example.roombottomnavigation.room.AppDatabase
import com.example.roombottomnavigation.room.Group
import kotlinx.android.synthetic.main.fragment_students.*

class FragmentGroup : Fragment(R.layout.fragment_students) {

    private val adapterGroup = AdapterGroup()

    private lateinit var groups: MutableList<Group>

    var handler = Handler(Looper.getMainLooper())


    companion object {
        fun newInstance() = FragmentGroup().apply {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewStudent.adapter = adapterGroup
        var db = AppDatabase.getDataBase(view.context)
        var dao = db?.groupDao()
        Thread {
            groups = dao?.getAllGroup() as MutableList<Group>
            handler.post(object : Runnable{
                override fun run() {
                    adapterGroup.dataGroups = groups
                }
            })
        }.start()
    }
}