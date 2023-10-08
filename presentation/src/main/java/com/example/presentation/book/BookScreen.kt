package com.example.presentation.book

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.presentation.model.BookItem

@Composable
fun BookScreen(
    viewModel: BookViewModel,
    navigateToBookDetail: (BookItem) -> Unit
) {
    val onEvent: (BookScreenEvent) -> Unit = remember { { viewModel.onEvent(it) } }
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.effect.collect {
            when (it) {
                is BookScreenEffect.NavigateToBookDetailFragment ->
                    navigateToBookDetail(it.bookItem)
            }
        }
    }

    BookContent(
        state = state,
        onEvent = onEvent,
    )
}

@Composable
fun BookContent(
    state: BookScreenState,
    onEvent: (BookScreenEvent) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = state.books,
        ) { book ->
            BookItemComponent(book) {
                onEvent(BookScreenEvent.BookDetailsClicked(it))
            }
        }
    }
}
