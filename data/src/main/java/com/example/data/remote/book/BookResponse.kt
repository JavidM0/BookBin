package com.example.data.remote.book

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("results") val results: BookDto
)

data class BookDto(
    @SerializedName("books") val books: List<Book>
)

data class Book(
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("book_image") val imagePath: String,
    @SerializedName("description") val description: String
)


