package com.example.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class RollingDice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rolling_dice)

        val returnBtn : ImageButton = findViewById(R.id.imageButton)

        val rollAct = Intent(this, MainActivity::class.java)

        val amount: Int = intent.getIntExtra("amount", 1)

        returnBtn.setOnClickListener {
            startActivity(rollAct)
        }

        val rollButton: Button = findViewById(R.id.btn)
        rollButton.setOnClickListener{ rollDice(amount) }

    }

    private fun rollDice(dieTotal : Int) {

        val dice = DiceUpdate()
        val diceImage : ImageView = findViewById(R.id.dice1_img)
        val diceImage2 : ImageView = findViewById(R.id.dice2_img)
        val diceImage3 : ImageView = findViewById(R.id.dice3_img)
        val diceImage4 : ImageView = findViewById(R.id.dice4_img)
        val diceImage5 : ImageView = findViewById(R.id.dice5_img)
        val diceImage6 : ImageView = findViewById(R.id.dice6_img)

        val diceTotal : TextView = findViewById(R.id.totalText)

        when (dieTotal) {

            1 -> diceTotal.text = dice.updateDice(diceImage)
            2 -> {
                val dice1 = dice.updateDice(diceImage).toInt()
                val dice2 = dice.updateDice(diceImage2).toInt()
                val diceUpdate = Dice(dice1, dice2)
                diceTotal.text = diceUpdate.updateTotal()
            }

            3 -> {
                val dice1 = dice.updateDice(diceImage).toInt()
                val dice2 = dice.updateDice(diceImage2).toInt()
                val dice3 = dice.updateDice(diceImage3).toInt()
                val diceUpdate = Dice(dice1, dice2, dice3)
                diceTotal.text = diceUpdate.updateTotal()
                }

            4 -> {
                val dice1 = dice.updateDice(diceImage).toInt()
                val dice2 = dice.updateDice(diceImage2).toInt()
                val dice3 = dice.updateDice(diceImage3).toInt()
                val dice4 = dice.updateDice(diceImage4).toInt()
                val diceUpdate = Dice(dice1, dice2, dice3, dice4)
                diceTotal.text = diceUpdate.updateTotal()
            }

            5 -> {
                val dice1 = dice.updateDice(diceImage).toInt()
                val dice2 = dice.updateDice(diceImage2).toInt()
                val dice3 = dice.updateDice(diceImage3).toInt()
                val dice4 = dice.updateDice(diceImage4).toInt()
                val dice5 = dice.updateDice(diceImage5).toInt()
                val diceUpdate = Dice(dice1, dice2, dice3, dice4, dice5)
                diceTotal.text = diceUpdate.updateTotal()
            }

            6 -> {
                val dice1 = dice.updateDice(diceImage).toInt()
                val dice2 = dice.updateDice(diceImage2).toInt()
                val dice3 = dice.updateDice(diceImage3).toInt()
                val dice4 = dice.updateDice(diceImage4).toInt()
                val dice5 = dice.updateDice(diceImage5).toInt()
                val dice6 = dice.updateDice(diceImage6).toInt()
                val diceUpdate = Dice(dice1, dice2, dice3, dice4, dice5, dice6)
                diceTotal.text = diceUpdate.updateTotal()
            }

        }


    }

}

class Dice {

    var dice1 : Int = 0
    var dice2 : Int = 0
    var dice3 : Int = 0
    var dice4 : Int = 0
    var dice5 : Int = 0
    var dice6 : Int = 0
    constructor(dice1: Int) {
        this.dice1 = dice1
    }

    constructor(dice1: Int, dice2: Int) {
        this.dice1 = dice1
        this.dice2 = dice2
    }

    constructor(dice1: Int, dice2: Int, dice3: Int) {
        this.dice1 = dice1
        this.dice2 = dice2
        this.dice3 = dice3
    }

    constructor(dice1: Int, dice2: Int, dice3: Int, dice4: Int) {
        this.dice1 = dice1
        this.dice2 = dice2
        this.dice3 = dice3
        this.dice4 = dice4
    }

    constructor(dice1: Int, dice2: Int, dice3: Int, dice4: Int, dice5: Int) {
        this.dice1 = dice1
        this.dice2 = dice2
        this.dice3 = dice3
        this.dice4 = dice4
        this.dice5 = dice5
    }

    constructor(dice1: Int, dice2: Int, dice3: Int, dice4: Int, dice5: Int, dice6: Int) {
        this.dice1 = dice1
        this.dice2 = dice2
        this.dice3 = dice3
        this.dice4 = dice4
        this.dice5 = dice5
        this.dice6 = dice6
    }

    fun updateTotal(): String {
        val total = (dice1 + dice2 + dice3 + dice4 + dice5 + dice6)
        return total.toString()
    }


}

class DiceUpdate() {

    fun roll(): Int {
        return (1..6).random()
    }

    fun updateDice(diceImage : ImageView) : String {
        val newRoll = roll()

        val diceDrawable = when (newRoll) {

            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6

        }

        diceImage.setImageResource(diceDrawable)
        diceImage.contentDescription = newRoll.toString()
        return newRoll.toString()


    }
}