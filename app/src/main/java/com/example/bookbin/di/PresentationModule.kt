package com.example.bookbin.di

import com.example.presentation.book.BookViewModel
import com.example.presentation.bookDetail.BookDetailViewModel
import com.example.presentation.model.BookItem
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        BookViewModel(bookRepository = get())
    }

    viewModel { (bookItem: BookItem) ->
        BookDetailViewModel(bookItem)
    }
}
