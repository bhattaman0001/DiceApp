package com.example.DiceApp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val rolldice = Dice(6)
            val rand = rolldice.dice()
            val diceImage: ImageView = findViewById(R.id.imageView)
            val drawableResource = when (rand) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            val t1: TextView = findViewById(R.id.textView)
            diceImage.setImageResource(drawableResource)
            t1.text = rand.toString()
            t1.textSize = 25F
        }
    }
}

class Dice(val nums: Int) {
    fun dice(): Int {
        return (1..nums).random()
    }
}