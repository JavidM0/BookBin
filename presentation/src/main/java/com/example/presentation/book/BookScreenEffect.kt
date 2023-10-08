package com.example.presentation.book

import com.example.presentation.model.BookItem

sealed class BookScreenEffect {
    data class NavigateToBookDetailFragment(
        val bookItem: BookItem
    ) : BookScreenEffect()
}
