package com.example.myapplicationtry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    private lateinit var displaytextView: TextView
    private lateinit var averagetextView: TextView
    private lateinit var averagebutton:Button
    private lateinit var backbutton:Button
    private lateinit var displaybutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        displaytextView= findViewById(R.id.displaytextView)
        averagetextView= findViewById(R.id.averagetextView)
        displaybutton= findViewById(R.id.displaybutton)
        averagebutton= findViewById(R.id.averagebutton)
        backbutton= findViewById(R.id.averagebutton)


        displaybutton.setOnClickListener {
            val dateArray = intent.getStringArrayExtra("dateArray")
            val timeArrayMorning = intent.getStringArrayExtra("timeArrayMorning")
            val timeArrayAfternoon = intent.getStringArrayExtra("timesArrayAfternoon")
            val notesArray = intent.getStringArrayExtra("noteArray")

            val information = StringBuilder()
            var totalscreentime=0.0
            for (int in dateArray?.indices ?: 0..0) {
                val morningTime = timeArrayMorning?.get(int)?.toDoubleOrNull() ?: 0.0
                val afternoonTime = timeArrayAfternoon?.get(int)?.toDoubleOrNull() ?: 0.0
                totalscreentime += morningTime + afternoonTime

                information.append("Date: ${dateArray?.get(int)}\n")
                information.append("Morning Screen Time: $morningTime\n")
                information.append("Afternoon Screen Time: $afternoonTime\n")
                information.append("Notes: ${notesArray?.get(int)}\n\n")
            }
            displaytextView.text = information.toString()

            val averagescreentime = totalscreentime / (dateArray?.size ?: 1)
            averagetextView.text = "Average Screen Time: %.2f".format(averagescreentime)
        }

        backbutton.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}