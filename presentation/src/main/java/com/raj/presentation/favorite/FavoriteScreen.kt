package com.raj.presentation.favorite

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raj.common.error.HttpRequestError
import com.raj.presentation.ui.component.ErrorUi

@Composable
@Preview
fun FavoriteScreen() {
    ErrorUi(networkError = HttpRequestError.SomeThingWentWrong(500))
}