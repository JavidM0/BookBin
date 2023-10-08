package com.example.presentation.book

import com.example.presentation.model.BookItem

sealed class BookScreenEvent {
    data class BookDetailsClicked(
        val book: BookItem
    ) : BookScreenEvent()
}
