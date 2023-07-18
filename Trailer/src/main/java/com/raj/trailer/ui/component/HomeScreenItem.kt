package com.raj.trailer.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun HomeScreenItem() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(5.dp)
    ) {
        Image(
            painter = ColorPainter(Color.Red),
            contentDescription = "movie image",
            modifier = Modifier.height(160.dp)
        )
        Text(
            text = "Title",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp
                ),
            style = TextStyle(color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Description",
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Normal)
        )
    }
}