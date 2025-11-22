package com.example.ictmakerthon.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Choose(
    modifier: Modifier = Modifier,
    onFreeWrite: () -> Unit,
    onFastSelect: () -> Unit,
    onChat: () -> Unit,
    onRecord: () -> Unit
) {
    Box(
        modifier = modifier
            .width(343.dp)
            .height(241.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(vertical = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "자유롭게 작성하기",
                fontSize = 24.sp,
                modifier = Modifier.clickable { onFreeWrite() }
            )

            Text(
                text = "빠른 선택하기",
                fontSize = 24.sp,
                modifier = Modifier.clickable { onFastSelect() }
            )

            Text(
                text = "마냥이와 대화하기",
                fontSize = 24.sp,
                modifier = Modifier.clickable { onChat() }
            )

            Text(
                text = "기록 보러 가기",
                fontSize = 24.sp,
                modifier = Modifier.clickable { onRecord() }
            )
        }
    }
}
