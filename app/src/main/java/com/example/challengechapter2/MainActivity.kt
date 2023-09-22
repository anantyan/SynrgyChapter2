package com.example.challengechapter2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challengechapter2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindView()
    }

    private fun bindView() {
        binding.calculateButton.setOnClickListener {
            implementasiHasil()
        }

        binding.imageView.setImageResource(R.drawable.ic_android)
    }

    private fun implementasiHasil() {
        val costOfService = binding.costOfService.text.toString().toDoubleOrNull() ?: 0.0
        val roundUp = binding.roundUpSwitch.isChecked
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            binding.optionTwentyPercent.id -> 0.20
            binding.optionEighteenPercent.id -> 0.18
            binding.optionFifteenPercent.id -> 0.15
            else -> 0.0
        }
        val tipAmount = costOfService.calculate(Calculation(), tipPercentage, roundUp)

        binding.tipResult.text = tipAmount.toString()
    }
}