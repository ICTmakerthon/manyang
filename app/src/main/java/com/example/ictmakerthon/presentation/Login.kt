package com.example.ictmakerthon.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ictmakerthon.R

@Composable
fun Login() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F4FF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(120.dp))

        // 로고 이미지
        Image(
            painter = painterResource(id = R.drawable.b), // 네 로고 파일 이름!
            contentDescription = "마냥 로고",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(198.dp))

        /** ------------------ 네이버 로그인 버튼 ------------------ **/
        Button(
            onClick = { /* TODO: 네이버 로그인 */ },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2DB400) // 네이버 초록
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.b),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text("Naver로 로그인", color = Color.White, fontSize = 17.sp)
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        /** ------------------ 구글 로그인 버튼 ------------------ **/
        Button(
            onClick = { /* TODO: 구글 로그인 */ },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.b),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text("Google로 로그인", color = Color.Black, fontSize = 17.sp)
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        /** ------------------ 카카오 로그인 버튼 ------------------ **/
        Button(
            onClick = { /* TODO: 카카오 로그인 */ },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF7E317) // 카카오 노랑
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.b),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text("카카오로 로그인", color = Color.Black, fontSize = 17.sp)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login()
}


