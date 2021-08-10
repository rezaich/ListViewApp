package com.zaich.learnlistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private val dataName = arrayOf("ibaso it01","bloon bl03","trn v90")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView:ListView = findViewById(R.id.lvList)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,dataName)
        listView.adapter = adapter
    }


}