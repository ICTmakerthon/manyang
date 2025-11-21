package com.example.ictmakerthon.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ictmakerthon.R

val name = "은지"

@Composable
fun MissionPopupBox(
    name: String = "은지",
    onClose: () -> Unit = {},
    onStartMission: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    var todoText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(0.92f)
            .wrapContentHeight()
            .background(Color.White, RoundedCornerShape(22.dp))
            .padding(20.dp)
    ) {

        // ---------------------------
        // 상단 제목 + X 닫기
        // ---------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "오늘의 미션",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "✕",
                fontSize = 24.sp,
                modifier = Modifier.clickable { onClose() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 미션 제목
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFDDEBFF), RoundedCornerShape(10.dp))
                .padding(14.dp)
        ) {
            Text(
                text = "마냥이와 친구라면 시뮬레이션 하기",
                fontSize = 16.sp,
                color = Color(0xFF3A4B77),
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        // 미션 설명
        Text(
            text = "이 미션은 마냥이와 친구라면 시뮬레이션 하므로써\n" +
                    "제3자의 입장에서 ${name}님의 상황을 바라보고 마음을 위안하며\n" +
                    "생각을 올바른 방향으로 이끌기 위함이에요!",
            fontSize = 15.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 미션 아이콘 박스
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(Color(0xFFF8FAFF), RoundedCornerShape(18.dp))
                .border(1.dp, Color(0xFFD1D8E6), RoundedCornerShape(18.dp))
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_ribbon),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "미션 성공하고 받을 아이템을 골라주세요!",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(18.dp))

        // 미션 하러 가기 버튼
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(Color(0xFFDDEBFF), RoundedCornerShape(12.dp))
                .clickable { onStartMission() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "미션 하러 가기",
                fontSize = 17.sp,
                color = Color(0xFF3A4B77),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        // 내일 투두리스트
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF2F2F2), RoundedCornerShape(12.dp))
                .clickable { expanded = !expanded }
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("내일 투두리스트 세 개 적기", fontSize = 15.sp)
            Text(if (expanded) "▴" else "▾", fontSize = 30.sp)
        }

        // ----- 투두리스트 입력박스 -----
        if (expanded) {
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .border(1.dp, Color(0xFFDADADA), RoundedCornerShape(10.dp))
                    .padding(10.dp)
            ) {
                BasicTextField(
                    value = todoText,
                    onValueChange = { todoText = it },
                    textStyle = TextStyle(fontSize = 15.sp),
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MissionPopupBoxPreview() {
    MissionPopupBox()
}

