package com.raj.presentation.favorite

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.raj.common.baseClasses.DataState
import com.raj.presentation.ui.component.ErrorUi
import com.raj.presentation.ui.component.HomeScreenItem
import com.raj.presentation.ui.component.LoadingUi

@Composable
fun FavoriteScreen(favoriteViewModel: FavoriteViewModel) {

    val dataState =
        favoriteViewModel.movieList.collectAsStateWithLifecycle(initialValue = DataState.Loading).value

    when (dataState) {
        is DataState.Error -> ErrorUi(networkError = dataState.exception)
        DataState.Loading -> LoadingUi()
        is DataState.Success -> {
            Column(Modifier.background(color = Color.Gray)) {
                Spacer(modifier = Modifier.statusBarsPadding())
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Search") },
                    modifier = Modifier
                        .fillMaxWidth()
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    items(dataState.baseResponseData.size) { position ->
                        val movies = dataState.baseResponseData[position]
                        HomeScreenItem(movies, isFavoriteListener = { isFavoriteSelected ->
                            movies.isFavorite = isFavoriteSelected
                        })
                    }
                }
            }
        }
    }
}