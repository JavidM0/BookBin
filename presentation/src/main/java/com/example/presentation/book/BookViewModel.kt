package com.example.presentation.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.BookRepository
import com.example.presentation.mapper.toBookItemModel
import com.example.presentation.model.BookItem
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(
    val bookRepository: BookRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<BookScreenState> =
        MutableStateFlow(BookScreenState(books = listOf<BookItem>().toImmutableList()))
    val uiState: StateFlow<BookScreenState> = _uiState

    private val _effect: MutableSharedFlow<BookScreenEffect> = MutableSharedFlow()
    val effect: SharedFlow<BookScreenEffect> = _effect

    init {
        viewModelScope.launch {
            val books = bookRepository.getBooks().
            results.books.map {
                it.toBookItemModel()
            }.toImmutableList()

            _uiState.emit(_uiState.value.copy(books = books))
        }
    }

    fun onEvent(event: BookScreenEvent) {
        viewModelScope.launch {
            when (event) {
                is BookScreenEvent.BookDetailsClicked -> _effect.emit(
                    BookScreenEffect.NavigateToBookDetailFragment(
                        event.book
                    )
                )
            }
        }
    }
}
