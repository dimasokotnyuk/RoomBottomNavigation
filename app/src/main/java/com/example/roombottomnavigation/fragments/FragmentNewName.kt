package com.example.roombottomnavigation.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.room.AppDatabase
import com.example.roombottomnavigation.room.Student
import kotlinx.android.synthetic.main.fragment_set_new_name.*

class FragmentNewName : Fragment(R.layout.fragment_set_new_name) {
    companion object {
        private const val KEY_STUDENT_ID = "KEY_STUDENT_ID"

        //use argument to get user
        fun newInstance(studentId: Int) = FragmentNewName().apply {
            arguments = Bundle().apply {
                putInt(KEY_STUDENT_ID, studentId)
            }
        }
    }

    private val idStudent: Int?
        get() =
            arguments?.takeIf { it.containsKey(KEY_STUDENT_ID) }?.getInt(KEY_STUDENT_ID)

    //load from database -> change in db
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSetNewName.setOnClickListener {
            if (etFirstName.text.isNotEmpty()) {
                val dao = AppDatabase.getDataBase(context)?.studentDao()
                val daoGroup = AppDatabase.getDataBase(context)?.groupDao()

                Thread {
                    val groupWithStudents = daoGroup?.getGroupWithStudents(1)
                    Log.e("FragmentNewName", "Group name ${groupWithStudents?.group?.nameGroup}")
                    groupWithStudents?.student?.forEach {
                        Log.e("FragmentNewName", "Student name ${it.firstName}")
                    }
                    idStudent?.let { id -> dao?.updateName(etFirstName.text.toString(), id) }
                    it.post { activity?.onBackPressed() }
                }.start()
            }
        }
    }
}