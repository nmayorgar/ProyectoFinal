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
import com.example.bustime.viewmodel.RutaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaRuta(navController: NavHostController, viewModel: RutaViewModel) {
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
                title = { Text("Gestión de Rutas", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Opciones de Gestión de Rutas", color = Color.White)

                Spacer(modifier = Modifier.height(24.dp))

                // Primera fila de opciones
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RutaOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1gDPo6dvki-dOHnlR1UT54EGB3obzGg0J&export=download",
                        label = "Agregar Ruta",
                        onClick = { navController.navigate("agregar_ruta") }
                    )
                    RutaOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1vmq7c9ckOvIcvLQIgEIXZsGAbjvwYbfg&export=download",
                        label = "Listar Rutas",
                        onClick = { navController.navigate("listar_rutas") }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Segunda fila de opciones
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RutaOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1fGTeRldKRhTWioS3DfyaZs7eHJ_S-rQC&export=download",
                        label = "Actualizar Ruta",
                        onClick = { navController.navigate("actualizar_ruta") }
                    )
                    RutaOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1izByBJrnMxKEZ1S8JskdCVXYvDLimuzh&export=download",
                        label = "Eliminar Ruta",
                        onClick = { navController.navigate("eliminar_ruta") }
                    )
                }
            }
        }
    }
}

@Composable
fun RutaOptionIcon(imageUrl: String, label: String, onClick: () -> Unit) {
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
