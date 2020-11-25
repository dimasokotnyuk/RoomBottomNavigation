package com.example.roombottomnavigation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.R

class FragmentNewName : Fragment(R.layout.fragment_set_new_name) {
    companion object {
        //use argument to get user
        fun newInstance() = FragmentNewName().apply { }
    }

    //load from database -> change in db
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}