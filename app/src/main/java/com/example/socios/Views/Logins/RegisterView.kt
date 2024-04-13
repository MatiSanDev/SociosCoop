package com.example.socios.Views.Logins

import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.socios.Components.MainButton
import com.example.socios.Components.maxWidthIn
import com.example.socios.R

@Composable
fun RegisterView(navController: NavController) {
    ContentRegisterView(navController)
}

/* TODO
Poner verificador de campos rellenados
Verificador de rut chileno
verificador de numeros
Verificar que ambas contrasenas sean iguales
Guardar datos en una bdd
*/
@Composable
fun ContentRegisterView(navController: NavController) {

    var rut by remember {
        mutableStateOf("")
    }
    var clave by remember {
        mutableStateOf("")
    }
    var clave2 by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
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

    Spacer(modifier = Modifier.height(8.dp))

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Te damos la bienvenida.", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Ingresa tus datos")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = rut,
            onValueChange = {
                rut = it
            },
            label = {
                Text(text = "Ingresa tu Rut, sin guión.")
            },
            singleLine = true,
            maxLines = 1,
            modifier = Modifier.maxWidthIn(280.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = clave,
            onValueChange = {
                clave = it
            },
            label = {
                Text(text = "Ingresa tu clave")
            },
            singleLine = true,
            maxLines = 1,
            modifier = Modifier.maxWidthIn(280.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = clave2,
            onValueChange = {
                clave2 = it
            },
            label = {
                Text(text = "Ingresa tu clave nuevamente")
            },
            singleLine = true,
            maxLines = 1,
            modifier = Modifier.maxWidthIn(280.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (rut.isNullOrEmpty() || clave.isNullOrEmpty() || clave2.isNullOrEmpty()) {
                    println("Complete todos los campos.")
                    Toast.makeText(context, "Complete todos los campos.", Toast.LENGTH_SHORT).show()
                } else if (!rut.all { it.isDigit() } || !(rut.length in 8..9)) {
                    println("Ingrese un RUT válido.")
                    Toast.makeText(context, "Ingrese un RUT válido.", Toast.LENGTH_SHORT).show()
                } else if (clave != clave2) {
                    println("Las claves deben ser idénticas.")
                    Toast.makeText(context, "Las claves deben ser idénticas.", Toast.LENGTH_SHORT).show()
                } else if (clave.length !in 4..10) {
                    println("La clave debe tener entre 4 y 10 caracteres.")
                    Toast.makeText(context, "La clave debe tener entre 4 y 10 caracteres.", Toast.LENGTH_SHORT).show()
                } else {
                    navController.navigate("Login")
                    println("Usuario registrado")
                    Toast.makeText(context, "Usuario registrado", Toast.LENGTH_SHORT).show()
                }
            }
            ,
            modifier = Modifier.height(50.dp).maxWidthIn(130.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)

            ) {
            Text("Registrar")
        }

        Spacer(modifier = Modifier.height(20.dp))

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
@Preview
@Composable
fun RegisterViewPreview() {
    val navController = rememberNavController()
    RegisterView(navController)
}