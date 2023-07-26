package com.example.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class RollingDice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rolling_dice)

        val returnBtn : ImageButton = findViewById(R.id.imageButton)

        val rollAct = Intent(this, MainActivity::class.java)

        returnBtn.setOnClickListener {
            startActivity(rollAct)
        }

    }
}