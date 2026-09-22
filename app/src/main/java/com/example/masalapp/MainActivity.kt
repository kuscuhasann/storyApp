package com.example.masalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.masalapp.presentation.navigation.MasalNavHost
import com.example.masalapp.ui.theme.MasalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val container = (application as MasalApplication).container
        setContent {
            MasalAppTheme {
                MasalNavHost(container = container)
            }
        }
    }
}
