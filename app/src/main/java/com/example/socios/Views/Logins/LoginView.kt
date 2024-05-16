package com.example.socios.Views.Logins

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
@Composable
fun LoginView (navController: NavController){
    LoginViewContent(navController)
}
@Composable
fun LoginViewContent(navController: NavController) {
    var mail by remember { mutableStateOf("admin") }
    var pass by remember { mutableStateOf("admin") }
    val context = LocalContext.current
    var viewModel: MainViewModel = viewModel()
    val userCreationResult by viewModel.userCreationResult.collectAsState()

    LaunchedEffect(userCreationResult) {
        when (val result = userCreationResult) {
            is MainViewModel.UserCreationResult.Success -> {
                val cantidad = result.data as? String ?: "0"

                viewModel.resetUserCreationResult()
                if (cantidad != "0") {  // O cualquier condición que definas basada en cantidad
                    Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Credenciales Inválidas", Toast.LENGTH_LONG).show()
                }
            }

            is MainViewModel.UserCreationResult.Error -> {
                Toast.makeText(context, "Error al iniciar sesión: ${result.message}", Toast.LENGTH_LONG).show()
            }
            null -> {

            }
        }
    }


    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            Text("Login Usuario", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = mail,
                onValueChange = { mail = it },
                label = { Text("Correo Electrónico") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done) )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { viewModel.loginUser(mail, pass) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp),
            ) {
                Text("Validar Credenciales")
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
/*@Composable
fun ContentLoginView(navController: NavController) {

    var mail by remember {
        mutableStateOf("")
    }
    var pass by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    var viewModel: MainViewModel = viewModel()
    val userCreationResult by viewModel.userCreationResult.collectAsState()

    LaunchedEffect(userCreationResult) {
        when ( val result = userCreationResult) {
            is MainViewModel.UserCreationResult.Success -> {
                val respuesta = result.data as String

                if(respuesta == "LOGIN OK"){
                    println("MSV: USUARIO CORRECTO NAVEGAMO")
                    }
                else{
                    println("MSV: CREDENCIALES INVALIDAS")
                }
            }

            is MainViewModel.UserCreationResult.Error -> {

            }

            null -> {
                println("PASA POR EL NULL.");
            }
        }
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

        CustomTextBox(
            text = "Bienvenido, socio.",
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        CustomTextBox(
            text = "Ingresa a tu cuenta",
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = mail,
            onValueChange = {
                mail = it
            },
            label = {
                Text(text = "Ingresa tu mail")
            },
            singleLine = true,
            maxLines = 1,
            modifier = Modifier.maxWidthIn(280.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = pass,
            onValueChange = {
                pass = it
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

        Button(
            onClick = {
                println("Mail: $mail")
                println("Clave: $pass")
                viewModel.loginUsuario(mail,pass)
                if (mail.isNullOrEmpty()) {
                    println("Ingrese un mail, por favor.")
                    Toast.makeText(context, "Ingrese un mail, por favor.", Toast.LENGTH_SHORT).show()
                } else if (pass.isNullOrEmpty()) {
                    println("Ingrese su clave.")
                    Toast.makeText(context, "Ingrese su clave.", Toast.LENGTH_SHORT).show()
                } else if (!mail.contains("@")) {
                    println("Correo electrónico inválido: Falta el caracter '@'")
                    Toast.makeText(context, "Correo electrónico inválido: Falta el caracter '@'", Toast.LENGTH_LONG).show()
                } else if (!validarCorreoElectronico(mail)) {
                    println("Correo electrónico inválido")
                    Toast.makeText(context, "Correo electrónico inválido", Toast.LENGTH_SHORT).show()
                } else if (pass.length !in 4..8) {
                    println("Clave incompleta (largo)")
                    Toast.makeText(context, "Clave incompleta (largo)", Toast.LENGTH_SHORT).show()
                }
                else {
                    navController.navigate("Home")
                }
            }
            ,
            modifier = Modifier.height(50.dp).maxWidthIn(130.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)

            ) {
            Text("Ingresar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        MainButton(name = "Registrate", backColor = Color.Transparent, color = Color.Unspecified) {
            navController.navigate("Register")
        }

        Spacer(modifier = Modifier.height(4.dp))

        MainButton(
            name = "¿Olvidaste tu clave?",
            backColor = Color.Transparent,
            color = Color.Unspecified
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
                CustomTextBox(
                    text = "Sucursales",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Default,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(0.dp)
                )
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
                CustomTextBox(
                    text = "Contacto",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Default,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(0.dp)
                )
            }
        }
    }
}*/