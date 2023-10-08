package com.example.presentation.book

import com.example.presentation.model.BookItem
import kotlinx.collections.immutable.ImmutableList

data class BookScreenState(
    val books: ImmutableList<BookItem>
)
