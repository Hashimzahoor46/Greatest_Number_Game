package com.example.firstever

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var btnleft: Button
    lateinit var btnrgt: Button

    //    lateinit var btnmid : Button
    lateinit var backgroundView: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnleft = findViewById(R.id.btnleft)
        btnrgt = findViewById(R.id.btnrgt)
        backgroundView = findViewById(R.id.backgroundView)




        randomAssign()
        btnleft.setBackgroundColor(Color.rgb(99,99,99))
        btnrgt.setBackgroundColor(Color.rgb(20,20,20))
        btnleft.setOnClickListener() {
//            compare the numbers in the boxes and assign the new random numbers
            checkAnswer(true)
            randomAssign()
        }
        btnrgt.setOnClickListener() {
            checkAnswer(false)
            randomAssign()
        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNUm: Int = btnleft.text.toString().toInt()
        val rgtNum: Int = btnrgt.text.toString().toInt()
        val isAnswerCorrect: Boolean =
            if (isLeftButtonSelected) leftNUm > rgtNum else rgtNum > leftNUm
        if (isAnswerCorrect) {
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
        } else {
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
        }
    }

    private fun randomAssign() {
        val rand = Random()
        val left: Int = rand.nextInt(10)
        var right = left

        while (right == left) {
            right = rand.nextInt(10)
        }
        btnleft.text = left.toString()
        btnrgt.text = right.toString()
    }
}


