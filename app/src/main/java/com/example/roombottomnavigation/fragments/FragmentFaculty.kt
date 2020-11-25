package com.example.roombottomnavigation.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.adapters.AdapterFaculty
import com.example.roombottomnavigation.room.AppDatabase
import com.example.roombottomnavigation.room.Faculty
import kotlinx.android.synthetic.main.fragment_students.*

class FragmentFaculty : Fragment(R.layout.fragment_students) {

    private val adapterFaculty = AdapterFaculty()

    private lateinit var facultyes: MutableList<Faculty>

    var handler = Handler(Looper.getMainLooper())


    companion object {
        fun newInstance() = FragmentFaculty().apply {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewStudent.adapter = adapterFaculty
        var db = AppDatabase.getDataBase(this.context)
        var dao = db?.facultyDao()
        Thread {
            facultyes = dao?.getAllFaculty() as MutableList<Faculty>
            handler.post(object : Runnable{
                override fun run() {
                    adapterFaculty.dataFaculty = facultyes
                }
            })
        }.start()
    }
}