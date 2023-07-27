package com.example.diceroller

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
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

    private fun rollDice(dieTotal : Int) {

        val dice = Dice()
        val diceImage : ImageView = findViewById(R.id.dice1_img)
        val diceImage2 : ImageView = findViewById(R.id.dice2_img)

        val diceTotal : TextView = findViewById(R.id.totalText)

        when (dieTotal) {

            1 -> diceTotal.text = dice.updateDice(diceImage)
            2 -> {
                val dice1 = dice.updateDice(diceImage)
                val dice2 = dice.updateDice(diceImage2)
                diceTotal.text = dice.updateTotal(dice1, dice2)
            }

        }


    }

}

class Dice() {

    fun roll(): Int {
        return (1..6).random()
    }

    fun updateDice(diceImage : ImageView) : String {
        val newRoll = roll()

        val diceDrawable = when (newRoll) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        diceImage.setImageResource(diceDrawable)
        diceImage.contentDescription = newRoll.toString()
        return newRoll.toString()


    }

    fun updateTotal(i: String, x: String): String {
        val total = (i.toInt()).plus(x.toInt())
        return total.toString()
    }


}