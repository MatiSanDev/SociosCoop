package com.example.socios.Views.Logins

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.socios.Components.MainButton
import com.example.socios.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginView(navController: NavController) {
    ContentLoginView(navController)
}

/* TODO
Poner verificador de campos rellenados
Verificador de rut chileno
verificador de numeros
Verificar que los datos sean los correctos en la bdd,
sino lanzar un aviso
*/
@Composable
fun ContentLoginView(navController: NavController) {

    var rut by remember {
        mutableStateOf("")
    }
    var clave by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Bienvenido, Socio.", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Ingresa a tu cuenta")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = rut, onValueChange = {
            rut = it
        }, label = {
            Text(text = "Ingresa tu RUT")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = clave, onValueChange = {
            clave = it
        }, label = {
            Text(text = "Ingresa tu clave")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        MainButton(name = "Ingresar", backColor = Color.Red, color = Color.White) {
            navController.navigate("Home")
        }

        Spacer(modifier = Modifier.height(20.dp))

        MainButton(name = "Registrate", backColor = Color.Transparent, color = Color.Black) {
            navController.navigate("Register")
        }

        Spacer(modifier = Modifier.height(4.dp))

        MainButton(
            name = "¿Olvidaste tu clave?",
            backColor = Color.Transparent,
            color = Color.Black
        ) {
            navController.navigate("Forgot")
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 40.dp),
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.ubicacion),
                    contentDescription = "Sucursal logo",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable {
                            navController.navigate("Directions")
                        })
                Text(text = "Sucursales", fontSize = 12.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.fono),
                    contentDescription = "Fono logo",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable {
                            navController.navigate("Contact")
                        })
                Text(text = "Contacto", fontSize = 12.sp)
            }
        }
    }
}