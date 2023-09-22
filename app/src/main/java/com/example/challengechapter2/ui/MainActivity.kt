package com.example.challengechapter2.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.challengechapter2.R
import com.example.challengechapter2.databinding.ActivityMainBinding
import com.example.challengechapter2.utils.costOfService
import com.example.challengechapter2.utils.roundUp
import com.example.challengechapter2.utils.tipPercentage
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
        binding.imageView.setImageResource(R.drawable.ic_android)
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