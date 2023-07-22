package com.raj.presentation.home

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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raj.common.baseClasses.DataState
import com.raj.presentation.ui.component.ErrorUi
import com.raj.presentation.ui.component.HomeScreenItem
import com.raj.presentation.ui.component.LoadingUi

val numbers = (0..20).toList()

@Composable
@Preview
fun HomeScreen() {
    val homeViewModel = viewModel<HomeViewModel>()
    val dataState =
        homeViewModel.movieList.collectAsStateWithLifecycle(initialValue = DataState.Loading).value

    when (dataState) {
        is DataState.Error -> ErrorUi(networkError = dataState.exception)
        DataState.Loading -> LoadingUi()
        is DataState.Success -> {
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

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    items(numbers.size) {
                        HomeScreenItem()
                    }
                }
            }
        }
    }
}