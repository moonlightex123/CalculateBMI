package com.example.bmicalculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.databinding.ActivityBMIBinding
import kotlin.math.pow

class BMI : AppCompatActivity() {
    lateinit var binding: ActivityBMIBinding
    var BMI : Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBMIBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personName = intent?.getStringExtra("personName")

        val tv = findViewById<TextView>(R.id.NameContent)
        tv.setText(personName)

        if(savedInstanceState != null){
            BMI = savedInstanceState.getDouble("bmiIndex")
            val tvStatus = binding.statusContent.text

        }

        binding.calculateBtn.setOnClickListener {
            var status = calculateBMI()
            binding.statusContent.text =  status
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex",BMI)
    }



    fun calculateBMI() : String{
        val weight = binding.weightText.text.toString().toDouble()
        val height = binding.heightText.text.toString().toDouble()
        var status = " "

        val BMI = weight/height.pow(2)

        if(BMI < 18.5){
           return "Underweight"
        }
        else if (BMI >=18.5 && BMI < 24.9){
            return "Normal Weight"
        }
        else if (BMI >=25.0 && BMI < 29.9){
            return "Overweight"
        }
        else if (BMI >=30.0 && BMI < 34.9){
            return "Obesity Class I"
        }
        else if (BMI >=35.0 && BMI < 39.9){
            return "Obesity Class II"
        }
        else{
            return "Obesity Class III"
        }
    }
}