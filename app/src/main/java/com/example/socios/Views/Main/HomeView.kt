package com.example.socios.Views.Main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.socios.Components.MyBottomAppBar
import com.example.socios.Components.MyTopAppBar
import com.example.socios.Components.Space
import com.example.socios.Components.TitleService
import com.example.socios.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            MyTopAppBar(navController)
        },
        bottomBar = {
            MyBottomAppBar(navController)
        }
    ) {
        ContentHomeView(navController)
    }
}


@Composable
fun ContentHomeView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Tus productos contratados:")
        Row {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    TitleService("AHORROS")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .clickable { /*TODO*/ }
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(10.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cuenta),
                        contentDescription = "Cuenta",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(60.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "VICTOR FABIAN GOMEZ CARU",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "Rut: 12.123.123-K", fontSize = 15.sp, color = Color.Gray)
                        Text(text = "N de cuenta: 1343", fontSize = 15.sp, color = Color.Gray)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Vigente ", fontSize = 15.sp, color = Color.Gray)
                            Icon(
                                Icons.Default.CheckCircle,
                                contentDescription = "Activo Icon",
                                tint = Color.Cyan,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                }
            }
        }
        Space()
        Row {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )

            ) {
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    TitleService("INVERSIONES")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .clickable { /*TODO*/ }
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(10.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.inversiones),
                        contentDescription = "Depositos",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(60.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "VICTOR FABIAN GOMEZ CARU",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "Rut: 12.123.123-K", fontSize = 15.sp, color = Color.Gray)
                        Text(text = "N de cuenta: 1343", fontSize = 15.sp, color = Color.Gray)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Vigente ", fontSize = 15.sp, color = Color.Gray)
                            Icon(
                                Icons.Default.CheckCircle,
                                contentDescription = "Activo Icon",
                                tint = Color.Cyan,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                }
            }
        }
        Space()
        Row {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    )

            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    TitleService("CRÉDITOS")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .clickable { /*TODO*/ }
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(10.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.creditos),
                        contentDescription = "Creditos",
                        modifier = Modifier.size(60.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "VICTOR FABIAN GOMEZ CARU",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "Rut: 12.123.123-K", fontSize = 15.sp, color = Color.Gray)
                        Text(text = "N de cuenta: 1343", fontSize = 15.sp, color = Color.Gray)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Vigente ", fontSize = 15.sp, color = Color.Gray)
                            Icon(
                                Icons.Default.CheckCircle,
                                contentDescription = "Activo Icon",
                                tint = Color.Cyan,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}