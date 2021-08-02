package com.example.info_store_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Getdata : AppCompatActivity() {

    val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

    private lateinit var database: FirebaseDatabase
    private lateinit var referance: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getdata)

        database = FirebaseDatabase.getInstance()
        referance=database.getReference("Users")
        getData()
    }

    private fun getData()
    {
        referance.addValueEventListener(object :ValueEventListener
        {
            override fun onCancelled(p0: DatabaseError) {
              Log.e("cancel",p0.toString())
            }

            override fun onDataChange(p0: DataSnapshot) {
                var list=ArrayList<DatabaseModel>()
                for(data in p0.children)
                {
                    var model=data.getValue(DatabaseModel::class.java)
                    list.add(model as DatabaseModel)
                }
                if(list.size > 0){
                    val adapter = DataAdapter(list)
                    recyclerView.adapter = adapter
                }
            }
        })
    }
}