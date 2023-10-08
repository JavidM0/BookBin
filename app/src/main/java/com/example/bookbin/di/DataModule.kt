package com.example.bookbin.di

import com.example.data.remote.book.BookApi
import org.koin.dsl.module

val dataModule = module {

    single<BookApi> {
        provideApi(retrofit = get())
    }
}
