package com.example.data.remote.book

import retrofit2.http.GET

interface BookApi {

    @GET("current/hardcover-fiction.json?api-key=An4nBzc3wf6hXdM7hteJEtGveAcRENqB")
    suspend fun getBookList(): BookResponse
}
