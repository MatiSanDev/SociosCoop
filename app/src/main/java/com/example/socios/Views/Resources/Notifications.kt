package com.example.socios.Views.Resources

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socios.Components.MyBottomAppBar
import com.example.socios.Components.MyTopAppBar
import com.example.socios.Components.TitleView
import com.example.socios.R

private val messages: List<MyMessage> = listOf(
    MyMessage(
        "Hola 1",
        "lLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specim"
    ),
    MyMessage(
        "Hola 2",
        "Proin molestie erat id ipsum ullamcorper egestas. Suspendisse dolor risus, posuere sed enim id, aliquet congue urna. Nulla sed laoreet est, ut maximus nisl. Morbi finibus aliquet dui ut eleifend. In et ex gravida, blandit velit lacinia, tincidunt nunc. In facilisis lacus ac justo fermentum, non sagittis neque convallis"
    ),
    MyMessage(
        "Hola 3",
        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
    ),
    MyMessage(
        "Hola 4",
        "eProin molestie erat id ipsum ullamcorper egestas. Suspendisse dolor risus, posuere sed enim id, aliquet congue urna. Nulla sed laoreet est, ut maximus nisl. Morbi finibus aliquet dui ut eleifend. In et ex gravida, blandit velit lacinia, tincidunt nunc. In facilisis lacus ac justo fermentum, non sagittis neque convallis"
    ),
    MyMessage(
        "Hola 5",
        "Proin molestie erat id ipsum ullamcorper egestas. Suspendisse dolor risus, posuere sed enim id, aliquet congue urna. Nulla sed laoreet est, ut maximus nisl. Morbi finibus aliquet dui ut eleifend. In et ex gravida, blandit velit lacinia, tincidunt nunc. In facilisis lacus ac justo fermentum, non sagittis neque convallis"
    ),
    MyMessage(
        "Hola 6",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specim"
    ),
    MyMessage(
        "Hola 7",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In arcu ligula, imperdiet eu turpis sit amet, interdum fermentum sapien. Etiam sodales est non sem hendrerit, vitae laoreet erat tincidunt. Nulla id nisi eget nulla sodales rutrum a ut lacus. Etiam magna massa, sollicitudin et odio a, sodales blandit justo. Vivamus blandit vehicula faucibus. Nullam congue risus at ligula venenatis, vel pharetra ipsum sagittis. In hac habitasse platea dictumst. Pellentesque sodales, urna quis commodo convallis, odio erat porttitor neque, condimentum vulputate ligula libero quis felis. Vestibulum magna libero, volutpat nec odio vitae, faucibus auctor sem."
    ),
    MyMessage(
        "Hola 8",
        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci vel"
    ),
    MyMessage(
        "Hola 9",
        "eLorem ipsum dolor sit amet, consectetur adipiscing elit. In arcu ligula, imperdiet eu turpis sit amet, interdum fermentum sapien. Etiam sodales est non sem hendrerit, vitae laoreet erat tincidunt. Nulla id nisi eget nulla sodales rutrum a ut lacus. Etiam magna massa, sollicitudin et odio a, sodales blandit justo. Vivamus blandit vehicula faucibus. Nullam congue risus at ligula venenatis, vel pharetra ipsum sagittis. In hac habitasse platea dictumst. Pellentesque sodales, urna quis commodo convallis, odio erat porttitor neque, condimentum vulputate ligula libero quis felis. Vestibulum magna libero, volutpat nec odio vitae, faucibus auctor sem."
    ),
    MyMessage(
        "Hola 10",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specim"
    ),
    MyMessage(
        "Hola 11",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In arcu ligula, imperdiet eu turpis sit amet, interdum fermentum sapien. Etiam sodales est non sem hendrerit, vitae laoreet erat tincidunt. Nulla id nisi eget nulla sodales rutrum a ut lacus. Etiam magna massa, sollicitudin et odio a, sodales blandit justo. Vivamus blandit vehicula faucibus. Nullam congue risus at ligula venenatis, vel pharetra ipsum sagittis. In hac habitasse platea dictumst. Pellentesque sodales, urna quis commodo convallis, odio erat porttitor neque, condimentum vulputate ligula libero quis felis. Vestibulum magna libero, volutpat nec odio vitae, faucibus auctor sem."
    ),
    MyMessage(
        "Hola 12",
        "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
    ),
    MyMessage(
        "Hola 13",
        "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain.."
    ),

    )

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
data class MyMessage(val title: String, val body: String)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotificationsView(navController: NavController, messages: List<MyMessage>) {
    Scaffold(
        topBar = {
            MyTopAppBar(navController)
        },
        bottomBar = {
            MyBottomAppBar(navController)
        }
    ) {
        ContentNotificationsView(navController = navController, messages = messages)
    }
}

@Composable
fun ContentNotificationsView(navController: NavController, messages: List<MyMessage>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, bottom = 75.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Notificaciones")
        LazyColumn {
            items(messages) { message ->
                MyComponent(message)
            }
        }
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .clickable {
                expanded = !expanded
            }
            .padding(15.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row {
            MyImage()
            MyTexts(message, expanded)
        }
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.iso3),
        "Imagen de notificacion",
        modifier = Modifier
            .clip(CircleShape)
            .size(64.dp)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun MyTexts(message: MyMessage, expanded: Boolean) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp)
    ) {
        MyText(
            text = message.title,
            style = MaterialTheme.typography.titleMedium
        )
        MySubText(
            text = message.body,
            color = Color.Gray,
            style = MaterialTheme.typography.labelMedium,
            lines = if (expanded) Int.MAX_VALUE else 1
        )
    }
}


@Composable
fun MyText(
    text: String,
    style: androidx.compose.ui.text.TextStyle,
    lines: Int = Int.MAX_VALUE
) {
    Text(text = text, style = style, maxLines = lines)
}

@Composable
fun MySubText(
    text: String,
    color: Color,
    style: androidx.compose.ui.text.TextStyle,
    lines: Int = Int.MAX_VALUE
) {
    Text(text = text, color = color, style = style, maxLines = lines)
}
