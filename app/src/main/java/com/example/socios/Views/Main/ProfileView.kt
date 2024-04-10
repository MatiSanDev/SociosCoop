package com.example.socios.Views.Main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socios.Components.MainButton
import com.example.socios.Components.MyBottomAppBar
import com.example.socios.Components.MyTopAppBar
import com.example.socios.Components.Space
import com.example.socios.Components.TextBox
import com.example.socios.Components.TextBoxTitle
import com.example.socios.R

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
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .padding(10.dp)) {
            Image(
                painter = painterResource(id = R.drawable.victor),
                contentDescription = "Profile image",
                Modifier
                    .clip(shape = CircleShape)
                    .size(100.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(10.dp),
        ) {
            Column(
                modifier = Modifier.padding(start = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextBoxTitle("Victor Fabian Gomez Caru")
                Space()
                TextBox("Rut: 12.123.123-K")
                Space()
                TextBox("Registrado desde: 30/04/2005")
                Space()
                TextBox("Dirección: Cerro Cruz 1234, Buín")
                Space()
                TextBox("Cantidad de productos adquiridos: 3")
                Space()
                MainButton(name = "Editar perfil", backColor = Color.Red, color = Color.White) {
                    navController.navigate("Configuration")
                }
            }
        }
    }
}