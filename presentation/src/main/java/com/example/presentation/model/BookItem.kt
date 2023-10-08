package com.example.presentation.model

import java.io.Serializable

data class BookItem(
    val title: String,
    val author: String,
    val imagePath: String,
    val description: String
) : Serializable
