package com.example.myapplicationtry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var eDate:EditText
    private lateinit var eMorning:EditText
    private lateinit var eAfternoon:EditText
    private lateinit var eNotes:EditText
    private lateinit var Savebutton:Button
    private lateinit var Cleanbutton:Button
    private lateinit var Nextbutton:Button
    private lateinit var tvMessage: TextView

    private val dateArray= mutableListOf<String>()
    private val MorningArrayTime= mutableListOf<Float>()
    private val AfternoonArrayTime= mutableListOf<Float>()
    private val notesArray= mutableListOf<String>()




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
        tvMessage= findViewById(R.id.tvMessage)



        Cleanbutton.setOnClickListener {
            eDate.setText("")
            eMorning.setText("")
            eAfternoon.setText("")
            eNotes.setText("")
        }

        Savebutton.setOnClickListener {
            val screenTimeDate = eDate.text.toString()
            val screenTimeMorning  = eMorning.text.toString()
            val screenTimeAfternoon= eAfternoon.text.toString()
            val screenTimeNote= eNotes.text.toString()

            if (screenTimeDate.isNotEmpty() && screenTimeMorning.isNotEmpty() && screenTimeAfternoon.isNotEmpty()){
             try{
                 dateArray.add(screenTimeDate)
                 MorningArrayTime.add(screenTimeMorning.toFloat())
                 AfternoonArrayTime.add(screenTimeAfternoon.toFloat())
                 notesArray.add(screenTimeNote)
                 eDate.text.clear()
                 eMorning.text.clear()
                 eAfternoon.text.clear()
                 eNotes.text.clear()
             }catch (e: NumberFormatException){
                 tvMessage.text= "Please entre a valid number"
             }

            } else{
                tvMessage.text= "Input cannot be empty"
            }
        }

        Nextbutton.setOnClickListener {
            val intent=Intent(this,MainActivity3::class.java)
               intent.putExtra("dateArray", dateArray.toTypedArray())
            intent.putExtra("MorningArrayTime", MorningArrayTime.toFloatArray())
            intent.putExtra("AfternoonArrayTime", AfternoonArrayTime.toFloatArray())
            intent.putExtra("notesArray", notesArray.toTypedArray())
            startActivity(intent)
        }


    }
}