package com.example.domain.repository

import com.example.data.remote.book.BookApi
import com.example.data.remote.book.BookResponse

class BookRepository(private val api: BookApi) {

    suspend fun getBooks(): BookResponse =
        api.getBookList()
}
