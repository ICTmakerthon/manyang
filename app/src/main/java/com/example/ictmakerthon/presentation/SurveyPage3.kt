package com.example.ictmakerthon.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ictmakerthon.R

@Composable
fun SurveyPage3() {

    val hobbyList = listOf(
        ""
    )

    var selectedHobbies by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F4FF))
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(121.dp))

        /** 캐릭터 + 말풍선 **/
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            //캐릭터
            Image(
                painter = painterResource(id = R.drawable.d),  // 캐릭터 이미지
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                modifier = Modifier.wrapContentSize()
            ){
                Box(
                    modifier = Modifier
                        .background(Color(0xFFBFD8FF), RoundedCornerShape(12.dp))
                        .padding(30.dp, 38.dp)
                ) {

                    Text(
                        text = "어떤 목적으로 마냥이를 설치하게 되었나요?\n(최대 3개)",
                        fontFamily = FontFamily(Font(R.font.thisisfont)),
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }
                Text(
                    text = "3/3",
                    fontFamily = FontFamily(Font(R.font.thisisfont)),
                    fontSize = 20.sp,
                    color = Color(0xFF3581FF),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(y = (-18).dp, x = (4).dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        /** 취미 선택 버튼 리스트 **/
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            hobbyList.forEach { hobby ->

                val isSelected = selectedHobbies.contains(hobby)

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Button(
                        onClick = {
                            selectedHobbies = if (isSelected) {
                                selectedHobbies - hobby
                            } else {
                                if (selectedHobbies.size < 3) selectedHobbies + hobby else selectedHobbies
                            }
                        },
                        modifier = Modifier
                            .width(330.dp)
                            .height(50.dp)
                            .border(
                                width = 2.dp,
                                color = Color(0xFF77AAFF),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) Color(0xFFBFD8FF) else Color.White
                        )
                    ) {
                        Text(
                            text = hobby,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.thisisfont)),
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SurveyPage3Preview() {
    SurveyPage3()
}