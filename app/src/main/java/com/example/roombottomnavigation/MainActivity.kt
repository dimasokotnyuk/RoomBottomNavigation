package com.example.roombottomnavigation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.roombottomnavigation.fragments.*
import com.example.roombottomnavigation.room.*
import com.example.roombottomnavigation.room.dao.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), FragmentStudentCallback {

    var dbTest: AppDatabase? = null

    var daoStudent: StudentDao? = null

    var daoGroup: DaoGroup? = null

    var daoUniversity: DaoUniversity? = null

    var daoFaculty: DaoFaculty? = null

    var daoUsers: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceFragment(FragmentStudent.newInstance(), false)
        }
        dbTest = AppDatabase.getDataBase(this)

        initializationDao()
//        insertData()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            replaceFragment(
                when (item.itemId) {
                    R.id.page_1 -> FragmentStudent.newInstance()
                    R.id.page_2 -> FragmentGroup.newInstance()
                    R.id.page_3 -> FragmentFaculty.newInstance()
                    else -> FragmentUniversity.newInstance()
                }, false
            )
            true
        }
    }

    override fun onUserClicked(item: Student) {
        Log.i("log", item.id.toString())
        item.id?.let { replaceFragment(FragmentNewName.newInstance(it), true) }
    }

    private fun generateStudents() {
        daoStudent?.deleteAllStudents()
        for (i in 1..20) {
            daoStudent?.insertStudent(
                Student(
                    firstName = "Dima$i",
                    lastName = "Sokotnyuk$i",
                    groupId = Random.nextInt(5) + 1,
                    faculty = "MEHMAT$i",
                    university = "DNU$i"
                )
            )
        }
    }

    private fun generateGroup() {
        daoGroup?.deleteAllGroup()
        for (i in 1..5) {
            daoGroup?.insertGroup(
                Group(
                    i,
                    "MT$i",
                    "DNU$i",
                     "MEHMAT$i",
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

    private fun generateUsers() {
        for (i in 1..20) {
            daoUsers?.insertUser(
                User(
                    i,
                    "MEHMAT$i",
                    Address(
                        "Street $i",
                        "State $i",
                        "City $i",
                        i
                    )
                )
            )
        }
    }

    fun insertData() {
        Thread {
            generateGroup()
            generateStudents()
            generateFaculty()
            generateUniversity()
            generateUsers()
        }.start()
    }

    private fun replaceFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        supportFragmentManager.apply {
            beginTransaction().apply {
                replace(
                    container.id,
                    fragment
                )
                if (isAddToBackStack) addToBackStack(fragment::class.simpleName)
            }.commit()
        }
    }

    fun initializationDao() {
        daoStudent = dbTest?.studentDao()
        daoGroup = dbTest?.groupDao()
        daoFaculty = dbTest?.facultyDao()
        daoUniversity = dbTest?.universityDao()
        daoUsers = dbTest?.userDao()
    }

}