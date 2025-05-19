package com.example.bustime.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicio(navController: NavHostController) {
    val backgroundImageUrl = "https://drive.usercontent.google.com/uc?id=1USuyXxYOQbQQBsSmwr2Lpi0oN4rClBz7&export=download"

    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = backgroundImageUrl,
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier.fillMaxSize().background(Color(0xAA000000))
        )

        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Bienvenido a Bustime", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Seleccione una opción para comenzar",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Primera fila de opciones
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    InicioOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1H4r2WpCmiZehwyOu8XzQFHv3Nkdp72Ln&export=download",
                        label = "Pasajeros",
                        onClick = { navController.navigate("Pasajeros") } // ✅ Ahora está correctamente registrado
                    )

                    InicioOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1EooObwygSQvJG1C3ZpapGNo1H0s_zduS&export=download", // Icono de conductores
                        label = "Conductores",
                        onClick = { navController.navigate("conductores") }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Segunda fila de opciones
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    InicioOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1PWlHnT4dVoTDvzfxyzfu9Sicaab6T2-T&export=download", // Icono de rutas
                        label = "Ruta",
                        onClick = { navController.navigate("pantalla_rutas") }
                    )
                    InicioOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1bRAZTuwDQNkbOWuXNz8hCMhIX_d3JkjL&export=download", // Icono de autobuses
                        label = "Autobus",
                        onClick = { navController.navigate("pantalla_autobuses") }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Tercera fila de opciones
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    InicioOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1oUTU7YwBiwZKBlHsjOwhPSdr-RhsQuXs&export=download", // Icono de rutas
                        label = "Horario",
                        onClick = { navController.navigate("pantalla_Horarios") }
                    )
                }
            }
        }
    }
}

@Composable
fun InicioOptionIcon(imageUrl: String, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp).clickable(onClick = onClick)
    ) {
        AsyncImage(model = imageUrl, contentDescription = label, modifier = Modifier.size(80.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)
    }
}