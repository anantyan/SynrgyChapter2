package com.example.challengechapter2.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.challengechapter2.R
import com.example.challengechapter2.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindView()
        bindObserver()
    }

    private fun bindView() {
        binding.calculateButton.setOnClickListener {
            bindInteractionUI()
        }

        binding.imageView.setImageResource(R.drawable.ic_android)
    }

    private fun bindObserver() {
        lifecycleScope.launch {
            viewModel.tipAmount.collect { tipAmount ->
                binding.tipResult.text = tipAmount.toString()
            }
        }
    }

    /**
     * Interaction UI
     *
     * Yang dimana implementasi ketika pengguna klik maka otomatis berinteraksi dengan viewModel
     * hasil inputnya masuk ke viewModel calculateTip
     *
     * @return [Unit] data masuk ke viewModel
     * */
    private fun bindInteractionUI() {
        val costOfService = binding.costOfService.text.toString().toDoubleOrNull() ?: 0.0
        val roundUp = binding.roundUpSwitch.isChecked
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            binding.optionTwentyPercent.id -> 0.20
            binding.optionEighteenPercent.id -> 0.18
            binding.optionFifteenPercent.id -> 0.15
            else -> 0.0
        }
        viewModel.calculateTip(costOfService, tipPercentage, roundUp)
    }
}