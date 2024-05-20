package com.example.myapplicationtry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var eDate:TextView
    private lateinit var eMorning:TextView
    private lateinit var eAfternoon:TextView
    private lateinit var eNotes:TextView
    private lateinit var Savebutton:Button
    private lateinit var Cleanbutton:Button
    private lateinit var Nextbutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        eDate= findViewById(R.id.eDate)
        eMorning= findViewById(R.id.eMorning)
        eAfternoon= findViewById(R.id.eAfternoon)
        eNotes= findViewById(R.id.eNotes)
        Savebutton= findViewById(R.id.Savebutton)
        Cleanbutton= findViewById(R.id.Cleanbutton)
        Nextbutton= findViewById(R.id.Nextbutton)

        val dateArray= arrayOfNulls<String>(7)
        val MorningArrayTime= arrayOfNulls<String>(7)
        val AfternoonArrayTime= arrayOfNulls<String>(7)
        val notesArray= arrayOfNulls<String>(7)

        Cleanbutton.setOnClickListener {
            eDate.setText("")
            eMorning.setText("")
            eAfternoon.setText("")
            eNotes.setText("")
        }

        Savebutton.setOnClickListener {
            dateArray[0]= eDate.text.toString()
            MorningArrayTime[0]= eMorning.text.toString()
            AfternoonArrayTime[0]= eAfternoon.text.toString()
            notesArray[0]= eNotes.text.toString()
        }

        Nextbutton.setOnClickListener {
            val intent=Intent(this,MainActivity3::class.java).apply {
                putExtra("dateArray",dateArray)
                putExtra("MorningArrayTime",MorningArrayTime)
                putExtra("AfternoonArrayTime",AfternoonArrayTime)
                putExtra("notesArray",notesArray)
            }
            startActivity(intent)
        }


    }
}