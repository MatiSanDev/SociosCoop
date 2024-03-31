package com.example.socios.Views.Resources

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.socios.Components.Space
import com.example.socios.R
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavController){
    SplashContent(navController)
    LaunchedEffect(key1 = true) {
        delay(1500)
        navController.popBackStack()
        navController.navigate("Login")
    }
}

@Composable
fun SplashContent(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.iso2),
            contentDescription = "Logo",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape))

        Space()
        Space()

        Text(text = "Iniciando...",
            fontSize = 15.sp,
            color = Color.Black,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold)
    }
}