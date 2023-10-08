package com.example.bookbin.di

import com.example.domain.repository.BookRepository
import org.koin.dsl.module

val domainModule = module {

    factory {
        BookRepository(api = get())
    }
}
