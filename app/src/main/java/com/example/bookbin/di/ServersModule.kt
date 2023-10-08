package com.example.bookbin.di

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val serversModule = module {

    single {
        provideRetrofit(
            client = provideOkHttpClient(),
        )
    }
}

private fun provideRetrofit(
    client: OkHttpClient,
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(createGsonFactory())
        .build()
}

private fun createGsonFactory(): GsonConverterFactory {
    val gson = GsonBuilder()
        .setLenient()
        .create()
    return GsonConverterFactory.create(gson)
}

private fun createInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(createInterceptor())
        .build()
}

private const val BASE_URL = "https://api.nytimes.com/svc/books/v3/lists/"
