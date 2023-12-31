package com.raj.presentation.favorite

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raj.presentation.home.numbers
import com.raj.presentation.ui.component.HomeScreenItem

@Composable
@Preview
fun FavoriteScreen() {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(numbers.size) {
            HomeScreenItem()
        }
    }
}