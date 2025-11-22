package com.example.ictmakerthon.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmotionDiaryBox(
    onClose: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    var diaryText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(0.90f)
            .wrapContentHeight()
            .background(Color.White, RoundedCornerShape(20.dp))
            .padding(20.dp)
    ) {

        // X 버튼 + 제목
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "오늘 하루 어떠셨나요?",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "✕",
                fontSize = 26.sp,
                modifier = Modifier.clickable { onClose() }
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        // 날짜 표시
        Text(
            text = "2025-03-02",
            modifier = Modifier.align(Alignment.End),
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        // 감정 선택 탭
        val emotions = listOf("슬픔", "불안", "보통", "기쁨", "최상")
        var selected by remember { mutableStateOf("슬픔") }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            emotions.forEach { emo ->
                Box(
                    modifier = Modifier
                        .background(
                            if (selected == emo) Color(0xFFDCE4FF) else Color(0xFFF3F3F3),
                            RoundedCornerShape(8.dp)
                        )
                        .clickable { selected = emo }
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = emo,
                        fontSize = 15.sp,
                        color = if (selected == emo) Color.Black else Color.Gray,
                        fontWeight = if (selected == emo) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 일기 입력 박스
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Color(0xFFFAFAFA), RoundedCornerShape(8.dp))
                .border(1.dp, Color(0xFFBFC5D1), RoundedCornerShape(8.dp))
                .padding(10.dp)
        ) {
            BasicTextField(
                value = diaryText,
                onValueChange = { diaryText = it },
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black
                ),
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 수정하기 / 저장하기 버튼
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "수정하기",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.clickable { }
            )

            Text(
                text = "저장하기",
                fontSize = 14.sp,
                color = Color(0xFF4069FF),
                modifier = Modifier.clickable { onSave() }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EmotionDiaryPreview() {
    EmotionDiaryBox()
}
