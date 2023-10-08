package com.example.presentation.bookDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.presentation.R

@Composable
fun BookDetailScreen(
    viewModel: BookDetailViewModel,
    navigateToBook: () -> Unit
) {
    val onEvent: (BookDetailScreenEvent) -> Unit = remember { { viewModel.onEvent(it) } }

    LaunchedEffect(key1 = Unit) {
        viewModel.effect.collect {
            when (it) {
                is BookDetailScreenEffect.NavigateToBookFragment ->
                    navigateToBook()
            }
        }
    }

    BookDetailContent(
        viewModel = viewModel,
        onEvent = onEvent
    )
}

@Composable
fun BookDetailContent(
    viewModel: BookDetailViewModel,
    onEvent: (BookDetailScreenEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(7.dp)
            .verticalScroll(rememberScrollState())
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(viewModel.bookItem.imagePath)
                .size(Size.ORIGINAL)
                .build()
        )

        Icon(
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = "back_icon",

            modifier = Modifier
                .size(30.dp)
                .clickable {
                    onEvent(BookDetailScreenEvent.BackClicked)
                }
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painter,
                contentDescription = "bookImageD",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(125.dp)
                    .padding(top = 45.dp)
                    .align(Alignment.Center)
            )
        }
        Text(
            text = viewModel.bookItem.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(top = 45.dp)
        )
        Text(
            text = viewModel.bookItem.description,
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp
            ),
            modifier = Modifier
                .padding(top = 5.dp)
        )
    }
}
