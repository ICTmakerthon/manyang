package com.example.ictmakerthon.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ictmakerthon.R
import androidx.compose.ui.res.painterResource
import com.example.ictmakerthon.presentation.components.Choose
import com.example.ictmakerthon.presentation.components.EmotionDiaryBox
import com.example.ictmakerthon.presentation.components.MissionPopupBox

@Composable
fun ChoosePage(navController: NavController) {
    var showDiary by remember { mutableStateOf(false) }
    var showPopup by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
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
            onFreeWrite = { showDiary = true },
            onFastSelect = { navController.navigate("feeling") },
            onChat = { /* TODO */ },
            onRecord = { /* TODO */ }
        )

        if (showDiary) {
            // 반투명 배경
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { showDiary = false },    // 바깥 클릭 시 닫힘
                contentAlignment = Alignment.Center
            ) {
                EmotionDiaryBox(
                    onClose = { showDiary = false },
                    onSave = { showDiary = false }
                )
            }
        }

        Box(
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.BottomEnd)
                .padding(20.dp)
                .alpha(0f)                // 완전 투명
                .clickable { showPopup = true }
        )

        // 🔹 Mission Popup
        if (showPopup) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x88000000))
                    .clickable { showPopup = false },
                contentAlignment = Alignment.Center
            ) {
                MissionPopupBox(
                    onClose = { showPopup = false }
                )
            }
        }

    }
}
