package com.example.presentation.bookDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.presentation.model.BookItem
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class BookDetailViewModel(
    val bookItem: BookItem
) : ViewModel() {

    private val _effect: MutableSharedFlow<BookDetailScreenEffect> = MutableSharedFlow(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val effect: SharedFlow<BookDetailScreenEffect> = _effect

    fun onEvent(event: BookDetailScreenEvent) {
        viewModelScope.launch {
            when (event) {
                is BookDetailScreenEvent.BackClicked -> _effect.emit(
                    BookDetailScreenEffect.NavigateToBookFragment
                )
            }
        }
    }
}
