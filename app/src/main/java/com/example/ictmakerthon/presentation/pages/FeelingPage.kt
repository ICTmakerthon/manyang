package com.example.ictmakerthon.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import com.example.ictmakerthon.R
import com.example.ictmakerthon.presentation.components.Feeling

@Composable
fun FeelingPage(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // 🔹 배경
        Image(
            painter = painterResource(id = R.drawable.feelingbackground),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        // 🔹 감정 카드
        Feeling(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-200).dp),
            onSelect = { selectedEmotion ->
                // TODO: 서버 전송 or 다음 페이지로 이동 가능
            }
        )
    }
}
