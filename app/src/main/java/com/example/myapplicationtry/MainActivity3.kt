package com.example.myapplicationtry

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var button3: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        textView2= findViewById(R.id.textView2)
        textView3= findViewById(R.id.textView3)
        textView4= findViewById(R.id.textView4)
        textView5= findViewById(R.id.textView5)
        button3= findViewById(R.id.button3)

        val dateArray= intent.getFloatArrayExtra("dateArray")?.toList()?: emptyList()
        val MorningArrayTime = intent.getFloatArrayExtra("MorningArrayTime")?.toList()?: emptyList()
        val AfternoonArrayTime= intent.getFloatArrayExtra("AfternoonArrayTime")?.toList()?: emptyList()
        val noteArray= intent.getStringArrayExtra("notesArray")?.toList()?: emptyList()

        val dated = StringBuilder()
        for ((index, date)in dateArray.withIndex()){
            dated.append("Day ${index + 1}: $date \n")
        }
        val hoursAM = StringBuilder()
        for ((index, time)in MorningArrayTime.withIndex()){
            hoursAM.append("Morning $index: $time \n")
        }
        val hoursPM = StringBuilder()
        for ((index,time)in AfternoonArrayTime.withIndex()){
            hoursPM.append("Afternoon $index: $time \n")
        }
        val noted = StringBuilder()
        for ((index, note)in noteArray.withIndex()){
            noted.append("Note $index: $note \n")
        }

        textView2.text= dated.toString()
        textView3.text= hoursAM.toString()
        textView3.text= hoursPM.toString()
        textView4.text= noted.toString()

        button3.setOnClickListener {
            finish()
        }




    }
}