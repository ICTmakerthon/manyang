package com.example.ictmakerthon.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.isSelected
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ictmakerthon.R

@Composable
fun Feeling(
    modifier: Modifier = Modifier,
    onSelect: (String) -> Unit
) {
    var selected by remember { mutableStateOf<String?>(null) }

    val emotions = listOf(
        "슬픔" to R.drawable.sad,
        "불안" to R.drawable.b,
        "보통" to R.drawable.c,
        "기쁨" to R.drawable.d,
        "최상" to R.drawable.e
    )


    Column(
        modifier = modifier
            .width(343.dp)
            .background(Color.White, RoundedCornerShape(20.dp))
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "오늘 기분은 어떠신가요?",
            modifier = Modifier.padding(bottom = 20.dp),
            fontSize = 28.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            emotions.forEach { (name, res) ->
                val isSelected = selected == name
                val scale by animateFloatAsState(
                    targetValue = if (isSelected) 1.12f else 1f
                )

                Column(
                    modifier = Modifier
                        .scale(scale)               // ← 애니메이션 적용
                        .clickable {
                            selected = name
                            onSelect(name)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = res),
                        contentDescription = name,
                        modifier = Modifier
                            .height(85.dp)
                            .aspectRatio(0.6f)
                            .clickable {
                                selected = name
                                onSelect(name)
                            }
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = name,
                    )
                }
            }
        }
    }
}


