package com.example.ictmakerthon.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import com.example.ictmakerthon.R
import com.example.ictmakerthon.presentation.components.EmotionDiaryBox

@Composable
fun EmotionDiaryPage(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // 🔹 배경 이미지
        Image(
            painter = painterResource(id = R.drawable.feelingbackground),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        // 🔹 감정 일기 박스
        EmotionDiaryBox(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-200).dp),
            onClose = { navController.popBackStack() },
            onSave = { /* 저장 처리 */ }
        )
    }
}
