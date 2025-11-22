package com.example.ictmakerthon.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ictmakerthon.presentation.pages.ChoosePage
import com.example.ictmakerthon.presentation.pages.FeelingPage
import com.example.ictmakerthon.ui.theme.ICTmakerthonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ICTmakerthonTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "choose"     // 첫 화면
    ) {
        // 🔹 ChoosePage
        composable("choose") {
            ChoosePage(navController)
        }

        // 🔹 FeelingPage
        composable("feeling") {
            FeelingPage(navController)
        }
    }
}
