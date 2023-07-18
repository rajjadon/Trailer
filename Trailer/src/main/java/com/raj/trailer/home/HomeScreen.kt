package com.raj.trailer.home

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raj.trailer.ui.component.HomeScreenItem

val numbers = (0..20).toList()

@Composable
@Preview
fun HomeScreen() {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(numbers.size) {
            HomeScreenItem()
        }
    }
}