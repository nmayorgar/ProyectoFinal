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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bustime.viewmodel.AutobusViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAutobus(navController: NavController, viewModel: AutobusViewModel) {
    val backgroundImageUrl = "https://drive.usercontent.google.com/uc?id=1USuyXxYOQbQQBsSmwr2Lpi0oN4rClBz7&export=download"

    Box(modifier = Modifier.fillMaxSize()) {
        // Imagen de fondo
        AsyncImage(
            model = backgroundImageUrl,
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Capa semitransparente encima
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xAA000000))
        )

        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Gestión de Autobuses", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Opciones de Gestión de Autobuses", color = Color.White)

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AutobusOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1bRAZTuwDQNkbOWuXNz8hCMhIX_d3JkjL&export=download", // Agregar
                        label = "Agregar Autobús",
                        onClick = { navController.navigate("agregar_autobus") }
                    )
                    AutobusOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1oUTU7YwBiwZKBlHsjOwhPSdr-RhsQuXs&export=download", // Listar
                        label = "Listar Autobuses",
                        onClick = { navController.navigate("listar_autobuses") }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AutobusOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1PWlHnT4dVoTDvzfxyzfu9Sicaab6T2-T&export=download", // Actualizar
                        label = "Actualizar Autobús",
                        onClick = { navController.navigate("actualizar_autobus") }
                    )
                    AutobusOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1g6xy1lAJnouZiuLCCzrUioSsIJpZcMWZ&export=download", // Eliminar
                        label = "Eliminar Autobús",
                        onClick = { navController.navigate("eliminar_autobus") }
                    )
                }
            }
        }
    }
}

@Composable
fun AutobusOptionIcon(imageUrl: String, label: String, onClick: () -> Unit) {
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
