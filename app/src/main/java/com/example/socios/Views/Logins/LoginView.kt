package com.example.socios.Views.Logins

import android.annotation.SuppressLint
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.socios.Components.CustomTextBox
import com.example.socios.Components.MainButton
import com.example.socios.Components.maxWidthIn
import com.example.socios.Components.validarCorreoElectronico
import com.example.socios.R
import com.example.socios.modelo.UsuarioLogin
import com.example.socios.util.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val isLoading = mutableStateOf(false)
    private val _userCreationResult = MutableStateFlow<UserCreationResult?>(null)
    val userCreationResult = _userCreationResult.asStateFlow()

    fun loginUsuario(mail: String, pass: String) {
        var usuario: UsuarioLogin
        usuario = UsuarioLogin(mail, pass)

        viewModelScope.launch {
            isLoading.value = true
            val response = RetrofitInstance.api.usuarioLogin(usuario)

            if (response.isSuccessful) {
                val respuesta = response.body()?.get(0)?.RESPUESTA
                _userCreationResult.value = UserCreationResult.Success(respuesta)
            } else {
                println("RESPUESTA ERROR")
                //_userCreationResult.value = UserCreationResult.Error(response.message())
            }
            isLoading.value = false
            resetUserCreationResult()
        }
    }

    fun resetUserCreationResult() {
        viewModelScope.launch {
            delay(1000)
            _userCreationResult.value = null
        }
    }

    sealed class UserCreationResult {
        data class Success(val data: Any?): UserCreationResult()
        data class Error(val message: String): UserCreationResult()
    }
}
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
}

@Preview
@Composable
fun LoginViewPreview() {
    val navController = rememberNavController()
    LoginView(navController)
}
