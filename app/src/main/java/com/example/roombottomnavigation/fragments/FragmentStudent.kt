package com.example.roombottomnavigation.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.interfaces.OnUserClickListener
import com.example.roombottomnavigation.adapters.AdapterStudent
import com.example.roombottomnavigation.room.AppDatabase
import com.example.roombottomnavigation.room.Student
import com.example.roombottomnavigation.room.StudentWithGroup
import kotlinx.android.synthetic.main.fragment_students.*


class FragmentStudent : Fragment(R.layout.fragment_students), OnUserClickListener {

    companion object {
        fun newInstance() = FragmentStudent().apply {
        }
    }

    private val adapterStudent = AdapterStudent(this) { studentWithGroup ->
        callback?.onUserClicked(studentWithGroup.student)
    }

    private lateinit var students: MutableList<StudentWithGroup>

    private var callback: FragmentStudentCallback? = null

    private var handler = Handler(Looper.getMainLooper())

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? FragmentStudentCallback
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewStudent.adapter = adapterStudent
        recyclerViewStudent.addItemDecoration(
            DividerItemDecoration(
                recyclerViewStudent.context,
                DividerItemDecoration.VERTICAL
            )
        )
        val dao = AppDatabase.getDataBase(view.context)?.studentDao()
        Thread {
            students = dao?.getAllStudentsWithGroups() as MutableList<StudentWithGroup>
            handler.post { adapterStudent.submitList(students) }
        }.start()
    }

    override fun onUserClick(user: Student) {
        Log.e("Student", "On student click event ${user.firstName}")
    }
}