package com.example.minichallengechapter2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.minichallengechapter2.databinding.ListItemMainBinding

class MainAdapter : ListAdapter<ItemModel, MainAdapter.ItemModelViewHolder>(ItemModelComparator) {
    private object ItemModelComparator : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemModelViewHolder {
        return ItemModelViewHolder(
            ListItemMainBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemModelViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    class ItemModelViewHolder(
        private val binding: ListItemMainBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: ItemModel) {
            binding.title.text = item.title
            binding.image.setImageResource(item.image ?: R.mipmap.ic_launcher_round)
        }
    }
}