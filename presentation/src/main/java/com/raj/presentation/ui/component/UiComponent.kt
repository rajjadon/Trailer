package com.raj.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raj.common.error.HttpRequestError
import com.raj.common.error.NetworkError

@Composable
@Preview
fun HomeScreenItem() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(5.dp)
            .background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
    ) {

        /*GlideImage(
            model = "", contentDescription = "movie banner", modifier = Modifier
                .height(160.dp)
                .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
        )*/

        Image(
            painter = ColorPainter(Color.White),
            contentDescription = "movie image",
            modifier = Modifier
                .height(160.dp)
                .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
        )
        Text(
            text = "Title",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp, start = 10.dp
                ),
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Description",
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
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = networkError.getErrorCode().toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp, start = 10.dp
                ),
            style = TextStyle(
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = networkError.getNetworkErrorMessage(),
            textAlign = TextAlign.Center,
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
            color = Color.White
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
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}