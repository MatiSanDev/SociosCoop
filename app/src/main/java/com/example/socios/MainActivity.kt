package com.example.socios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.socios.Screens.NavManager
import com.example.socios.Views.Main.MainViewModel
import com.example.socios.ui.theme.SociosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                val viewModel: MainViewModel = viewModel()
                viewModel.fetchOfficialDolar()
                NavManager()
            }
        }
    }
}




