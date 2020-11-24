package com.example.roombottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.fragments.*
import com.example.roombottomnavigation.room.*
import com.example.roombottomnavigation.room.dao.DaoFaculty
import com.example.roombottomnavigation.room.dao.DaoGroup
import com.example.roombottomnavigation.room.dao.DaoUniversity
import com.example.roombottomnavigation.room.dao.StudentDao
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_students.*
import kotlinx.android.synthetic.main.item_student.*

class MainActivity : AppCompatActivity() {

    var dbTest: AppDatabase? = null

    var daoStudent: StudentDao? = null

    var daoGroup: DaoGroup? = null

    var daoUniversity: DaoUniversity? = null

    var daoFaculty: DaoFaculty? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbTest = AppDatabase.getDataBase(this)

        initializationDao()
        insertData()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    replaceFragment(FragmentStudent.newInstance(), false)
                    true
                }
                R.id.page_2->{
                    replaceFragment(FragmentGroup.newInstance(), false)
                    true
                }
                R.id.page_3->{
                    replaceFragment(FragmentFaculty.newInstance(), false)
                    true
                }
                R.id.page_4->{
                    replaceFragment(FragmentUniversity.newInstance(), false)
                    true
                }
                else -> false
            }
        }
    }


    private fun generateStudents() {
        daoStudent?.deleteAllStudents()
        for (i in 1..20) {
            daoStudent?.insertStudent(
                Student(
                    firstName = "Dima$i",
                    lastName = "Sokotnyuk$i",
                    group = "MT$i",
                    faculty = "MEHMAT$i",
                    university = "DNU$i"
                )
            )
        }
    }

    private fun generateGroup() {
        daoGroup?.deleteAllGroup()
        for (i in 1..20) {
            daoGroup?.insertGroup(
                Group(
                    nameGroup = "MT$i",
                    univeristy = "DNU$i",
                    faculty = "MEHMAT$i",
                )
            )
        }
    }

    private fun generateUniversity() {
        daoUniversity?.deleteAllUniversity()
        for (i in 1..20) {
            daoUniversity?.insertUniversity(
                University(
                    nameUniversity = "DNU$i",
                    group = "MT$i",
                    faculty = "MEHMAT$i",
                )
            )
        }
    }

    private fun generateFaculty() {
        daoFaculty?.deleteAllFaculty()
        for (i in 1..20) {
            daoFaculty?.insertFaculty(
                Faculty(
                    nameFaculty = "MEHMAT$i",
                    group = "MT$i",
                    university = "DNU$i"
                )
            )
        }
    }

    fun insertData() {
        Thread {
            generateStudents()
            generateGroup()
            generateFaculty()
            generateUniversity()
        }.start()
    }

    private fun replaceFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        supportFragmentManager.apply {
            beginTransaction().apply {
                replace(
                    container.id,
                    fragment
                )
            }.commit()
        }
    }

    fun initializationDao() {
        daoStudent = dbTest?.studentDao()
        daoGroup = dbTest?.groupDao()
        daoFaculty = dbTest?.facultyDao()
        daoUniversity = dbTest?.universityDao()
    }

}