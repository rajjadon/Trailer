package com.raj.trailer.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raj.trailer.ui.component.HomeScreenItem

val numbers = (0..20).toList()

@Composable
@Preview
fun HomeScreen() {
    Column {
        Spacer(modifier = Modifier.statusBarsPadding())
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
        )

        LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.padding(top = 16.dp)) {
            items(numbers.size) {
                HomeScreenItem()
            }
        }
    }
}