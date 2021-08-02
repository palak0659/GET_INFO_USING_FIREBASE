package com.example.info_store_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var database:FirebaseDatabase
    private lateinit var referance:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = FirebaseDatabase.getInstance()
        referance=database.getReference("Users")

        btn_send.setOnClickListener{
            sendData()

        }
        btn_getdata.setOnClickListener{
            startActivity(Intent(applicationContext,Getdata::class.java))
        }

    }

    private fun sendData()
    {
        var name=inputName.text.toString().trim()
        var college=inputCollege.text.toString().trim()
        var field=inputfield.text.toString().trim()
        var Hobbies=inputHobbies.text.toString().trim()
        var Location=inputLocation.text.toString().trim()
        if(name.isNotEmpty() && college.isNotEmpty() && field.isNotEmpty() && Hobbies.isNotEmpty() && Location.isNotEmpty() )
        {
            var model=DatabaseModel(name, college, field, Hobbies, Location)
            var id=referance.push().key
            referance.child(id!!).setValue(model)
            inputName.setText("")
            inputCollege.setText("")
            inputfield.setText("")
            inputHobbies.setText("")
            inputLocation.setText("")


        }
        else{
            Toast.makeText(applicationContext,"All Field Required",Toast.LENGTH_SHORT).show()
        }
    }

}