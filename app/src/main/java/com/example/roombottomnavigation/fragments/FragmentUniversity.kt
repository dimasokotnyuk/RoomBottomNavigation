package com.example.roombottomnavigation.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.adapters.AdapterUniversity
import com.example.roombottomnavigation.room.AppDatabase
import com.example.roombottomnavigation.room.University
import kotlinx.android.synthetic.main.fragment_students.*

class FragmentUniversity : Fragment(R.layout.fragment_students) {

    private val adapterUniversity = AdapterUniversity()

    private lateinit var universities: MutableList<University>

    var handler = Handler(Looper.getMainLooper())


    companion object {
        fun newInstance() = FragmentUniversity().apply {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewStudent.adapter = adapterUniversity
        var db = AppDatabase.getDataBase(view.context)
        var dao = db?.universityDao()
        Thread {
            universities = dao?.getAllUniversity() as MutableList<University>
            handler.post(object : Runnable{
                override fun run() {
                    adapterUniversity.dataUniversity = universities
                }
            })
        }.start()
    }
}