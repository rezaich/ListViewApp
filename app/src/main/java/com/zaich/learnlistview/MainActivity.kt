package com.zaich.learnlistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /**
    private val dataName = arrayOf("ibaso it01","bloon bl03","trn v90")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView:ListView = findViewById(R.id.lvList)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,dataName)
        listView.adapter = adapter
    }
     */
    private lateinit var adapter: IemAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataPrice: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var iems = arrayListOf<IEM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lvList)
        adapter = IemAdapter(this)
        listView.adapter = adapter

        //untuk inisialisasi array
        prepare()
        //untuk memasukkan data
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, iems[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare(){
        dataName= resources.getStringArray(R.array.data_name)
        dataPrice= resources.getStringArray(R.array.data_price)
        dataPhoto=resources.obtainTypedArray(R.array.data_photo)
    }
    private fun addItem() {
        for (position in dataName.indices) {
            val Iem = IEM(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataPrice[position]
            )
            iems.add(Iem)
        }
        adapter.iem = iems
    }
}