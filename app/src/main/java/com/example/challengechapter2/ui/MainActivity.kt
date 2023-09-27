package com.example.challengechapter2.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.challengechapter2.R
import com.example.challengechapter2.databinding.ActivityMainBinding
import com.example.challengechapter2.common.costOfService
import com.example.challengechapter2.common.roundUp
import com.example.challengechapter2.common.tipPercentage
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
        binding.imageView.setImageResource(R.drawable.synrgy_academy)
        intercationButtonClickUI()
        interactionEditTextRealtimeUI()
        interactionSwitchRealtimeUI()
        interactionRadioGroupRealtimeUI()
    }

    private fun bindObserver() {
        lifecycleScope.launch {
            viewModel.tipAmount.collect { tipAmount ->
                binding.tipResult.text = "Tip Amount: $tipAmount"
            }
        }
    }

    private fun intercationButtonClickUI() {
        binding.btnCalculate.setOnClickListener {
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

    private fun interactionEditTextRealtimeUI() {
        binding.costOfService.costOfService(binding) { costOfService, tipPercentage, roundUp ->
            viewModel.calculateTip(costOfService, tipPercentage, roundUp)
        }
    }

    private fun interactionSwitchRealtimeUI() {
        binding.roundUpSwitch.roundUp(binding) { costOfService, tipPercentage, roundUp ->
            viewModel.calculateTip(costOfService, tipPercentage, roundUp)
        }
    }

    private fun interactionRadioGroupRealtimeUI() {
        binding.tipOptions.tipPercentage(binding) { costOfService, tipPercentage, roundUp ->
            viewModel.calculateTip(costOfService, tipPercentage, roundUp)
        }
    }
}