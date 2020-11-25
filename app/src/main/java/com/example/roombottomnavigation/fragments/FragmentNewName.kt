package com.example.roombottomnavigation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.R
import com.example.roombottomnavigation.room.AppDatabase
import kotlinx.android.synthetic.main.fragment_set_new_name.*

class FragmentNewName : Fragment(R.layout.fragment_set_new_name) {
    companion object {
        //use argument to get user
        fun newInstance(studentId: Int) = FragmentNewName().apply {
            idStudent = studentId
        }
    }

    var idStudent: Int? = null

    //load from database -> change in db
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSetNewName.setOnClickListener {
            if (etFirstName.text.isNotEmpty()) {
                val dao = AppDatabase.getDataBase(context)?.studentDao()
                Thread {
                    idStudent?.let { it1 -> dao?.updateName(etFirstName.text.toString(), it1) }
                }.start()
                activity?.onBackPressed()
            }
        }
    }
}