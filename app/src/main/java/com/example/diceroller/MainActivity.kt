package com.example.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var amount : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner : Spinner = findViewById(R.id.spinner)

        val button : Button = findViewById(R.id.button)

        val mainAct = Intent(this, RollingDice::class.java)

        ArrayAdapter.createFromResource(
            this,
            R.array.diceAmount,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                mainAct.putExtra("amount", (p2+1))

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                mainAct.putExtra("amount", (1))

            }

        }

        button.setOnClickListener {
            startActivity(mainAct)
        }

    }

}