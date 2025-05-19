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
import com.example.bustime.viewmodel.PasajerosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPasajeros(navController: NavHostController, viewmodel: PasajerosViewModel) {
    val backgroundImageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1USuyXxYOQbQQBsSmwr2Lpi0oN4rClBz7&export=download"

    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = backgroundImageUrl,
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xAA000000))
        )

        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Gestión de Pasajeros", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Opciones de Gestión de Pasajeros", color = Color.White)

                Spacer(modifier = Modifier.height(24.dp))

                // Opciones para Pasajeros
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Agregar Pasajero
                    PasajeroOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1bR3lx4UZllHtuqqSbpNCrbSfthx0yL0Q&export=download",
                        label = "Agregar Pasajero",
                        onClick = { navController.navigate("agregar_pasajeros") }
                    )
                    // Listar Pasajeros
                    PasajeroOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1H4r2WpCmiZehwyOu8XzQFHv3Nkdp72Ln&export=download",
                        label = "Listar Pasajeros",
                        onClick = { navController.navigate("listar_pasajeros") }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Actualizar Pasajero
                    PasajeroOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1ZrPnuLdCBAgG3kze7HOnP6NfRmIUC98B&export=download",
                        label = "Actualizar Pasajero",
                        onClick = { navController.navigate("actualizar_pasajero/{id}") }
                    )
                    // Eliminar Pasajero
                    PasajeroOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1izByBJrnMxKEZ1S8JskdCVXYvDLimuzh&export=download",
                        label = "Eliminar Pasajero",
                        onClick = { navController.navigate("eliminar_pasajero") }
                    )
                }
            }
        }
    }
}

@Composable
fun PasajeroOptionIcon(imageUrl: String, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = label,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}
