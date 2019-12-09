package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculate()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            clear()
        }
    }

    private fun calculate(){

        val weight = findViewById<EditText>(R.id.editTextWeight)
        val height = findViewById<EditText>(R.id.editTextHeight)

        val a = 2.00
        val bmitext = findViewById<TextView>(R.id.textViewBMI)
        val imgbmi = findViewById<ImageView>(R.id.imageViewProfile)


        try{
            val bmi = weight.text.toString().toDouble() / pow(height.text.toString().toDouble() / 100 ,a)

            bmitext.text = String.format("BMI:"+"%.2f",bmi)

            val drawableResource = when{

                bmi < 18.5 -> R.drawable.under
                bmi > 18.5 && bmi < 24.9 -> R.drawable.normal
                bmi > 25 -> R.drawable.over
                else -> R.drawable.empty
            }
            imgbmi.setImageResource(drawableResource)
            }catch (e:Exception){

        }

    }
    private fun clear(){
        findViewById<EditText>(R.id.editTextWeight).text = null
        findViewById<EditText>(R.id.editTextHeight).text = null
        findViewById<TextView>(R.id.textViewBMI).text = String.format("BMI:")
        findViewById<ImageView>(R.id.imageViewProfile).setImageResource(R.drawable.empty)

    }

}
