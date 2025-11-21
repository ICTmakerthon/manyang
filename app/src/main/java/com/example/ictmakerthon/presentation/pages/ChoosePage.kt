package com.example.ictmakerthon.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ictmakerthon.R
import androidx.compose.ui.res.painterResource
import com.example.ictmakerthon.presentation.components.Choose

@Composable
fun ChoosePage(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // 배경
        Image(
            painter = painterResource(id = R.drawable.feelingbackground),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        // 🔹 Choose 박스
        Choose(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-191).dp),
            onFreeWrite = { /* TODO */ },
            onFastSelect = { navController.navigate("feeling") },
            onChat = { /* TODO */ },
            onRecord = { /* TODO */ }
        )

    }
}
