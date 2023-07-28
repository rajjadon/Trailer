package com.raj.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.raj.common.error.HttpRequestError
import com.raj.common.error.NetworkError
import com.raj.domain.model.TrendingDomain

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeScreenItem(trendingDomain: TrendingDomain) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
    ) {

        Box {
            GlideImage(
                model = trendingDomain.posterPath,
                contentDescription = "movie banner",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            )
            FavoriteButton()
        }

        Text(
            text = trendingDomain.title.toString(),
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp, start = 10.dp
                ),
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "${trendingDomain.voteAverage?.toInt().toString()}/10",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, bottom = 16.dp
                ),
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

class SampleNetworkErrorProvider : PreviewParameterProvider<NetworkError> {
    override val values = sequenceOf(HttpRequestError.SomeThingWentWrong(500))
}

@Composable
@Preview
fun ErrorUi(@PreviewParameter(SampleNetworkErrorProvider::class) networkError: NetworkError) {
    Column(
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxSize()
    ) {
        Text(
            text = networkError.getNetworkErrorMessage(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp, start = 10.dp
                ),
            style = TextStyle(
                color = Color.Black,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = networkError.getErrorCode().toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, bottom = 16.dp
                ),
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
@Preview
fun LoadingUi(loadingMessage: String = "Loading data please wait") {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        CircularProgressIndicator(
            color = Color.Black
        )

        Text(
            text = loadingMessage,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, bottom = 16.dp
                ),
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}