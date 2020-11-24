package com.example.roombottomnavigation.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.adapters.AdapterStudent
import com.example.roombottomnavigation.room.AppDatabase
import com.example.roombottomnavigation.room.Student
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_students.*
import kotlinx.android.synthetic.main.item_student.*

class FragmentStudent : Fragment(R.layout.fragment_students) {

    private val adapterStudent = AdapterStudent()

    private lateinit var students: MutableList<Student>

    var handler = Handler(Looper.getMainLooper())


    companion object {
        fun newInstance() = FragmentStudent().apply {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewStudent.adapter = adapterStudent
        var db = AppDatabase.getDataBase(view.context)
        var dao = db?.studentDao()
        Thread {
            students = dao?.getAllStudents() as MutableList<Student>
            handler.post(object : Runnable {
                override fun run() {
                    adapterStudent.dataStudent = students
                }
            })
        }.start()
    }
}