package com.example.presentation.mapper

import com.example.data.remote.book.Book
import com.example.data.remote.book.BookResponse
import com.example.presentation.model.BookItem

fun Book.toBookItemModel(): BookItem {
    return BookItem(
        title = this.title,
        author = this.author,
        imagePath = this.imagePath,
        description = this.description,
    )
}
