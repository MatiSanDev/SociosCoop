package com.example.socios.Views.Main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.socios.Components.MyBottomAppBar
import com.example.socios.Components.MyTopAppBar
import com.example.socios.Components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileView(navController: NavController) {
    Scaffold(
        topBar = {
            MyTopAppBar(navController)
        },
        bottomBar = {
            MyBottomAppBar(navController)
        }
    ) {
        ContentProfileView(navController)
    }
}


@Composable
fun ContentProfileView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Perfil")
    }
}