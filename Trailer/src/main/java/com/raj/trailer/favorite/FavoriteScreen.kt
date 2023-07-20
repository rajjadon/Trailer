package com.raj.trailer.favorite

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raj.trailer.home.numbers
import com.raj.trailer.ui.component.HomeScreenItem

@Composable
@Preview
fun FavoriteScreen() {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(numbers.size) {
            HomeScreenItem()
        }
    }
}