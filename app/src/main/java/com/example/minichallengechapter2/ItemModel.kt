package com.example.minichallengechapter2

import androidx.annotation.DrawableRes

data class ItemModel(
    val id: Int? = null,
    val title: String? = null,
    @DrawableRes
    val image: Int? = null
)
