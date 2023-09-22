package com.example.minichallengechapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minichallengechapter2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindView()
    }

    private fun bindView() {
        adapter = MainAdapter()

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        adapter.submitList(dataDummy())
    }

    private fun dataDummy(): List<ItemModel> {
        return mutableListOf(
            ItemModel(
                1, "Bike", R.drawable.round_directions_bike_24
            ),
            ItemModel(
                2, "Car", R.drawable.round_directions_car_24
            ),
            ItemModel(
                3, "Food", R.drawable.round_fastfood_24
            ),
            ItemModel(
                4, "Delivery", R.drawable.round_delivery_dining_24
            )
        )
    }
}