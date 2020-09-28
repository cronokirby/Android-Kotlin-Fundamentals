package com.github.cronokirby.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        val current = resultText.text.toString().toIntOrNull()
        val next = when {
            current == null -> 0
            current >= 6 -> 6
            else -> current + 1
        }
        resultText.text = next.toString()
    }
}