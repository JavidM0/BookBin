package com.example.presentation.book

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.presentation.model.BookItem

@Composable
fun BookItemComponent(
    bookItem: BookItem,
    onItemClicked: (bookItem: BookItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(1.dp)
            .background(Color.White)
            .clickable {
                onItemClicked(bookItem)
            }

    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(bookItem.imagePath)
                .size(coil.size.Size.ORIGINAL)
                .build()
        )
        Image(
            painter = painter,
            contentDescription = "bookImage",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(80.dp)
                .height(90.dp)
                .align(Alignment.CenterVertically)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .padding(top = 5.dp)
        ) {
            Text(
                text = bookItem.title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = bookItem.author,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .padding(top = 15.dp)
            )
        }
    }
}
