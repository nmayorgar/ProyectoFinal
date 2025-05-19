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
import com.example.bustime.viewmodel.ConductoresViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaConductores(navController: NavHostController, viewModel: ConductoresViewModel) {
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
                title = { Text("Gestión de Conductores", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Opciones de Gestión de Conductores", color = Color.White)

                Spacer(modifier = Modifier.height(24.dp))

                // Opciones para Conductores
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Agregar Conductor
                    ConductorOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1EooObwygSQvJG1C3ZpapGNo1H0s_zduS&export=download", // Agregar Conductor
                        label = "Agregar Conductor",
                        onClick = { navController.navigate("agregar_conductor") }
                    )
                    // Listar Conductores
                    ConductorOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1LXFcp2c3F363EMEdbxzvaCx3Ry_GDkma&export=download", // Listar Conductores
                        label = "Listar Conductores",
                        onClick = { navController.navigate("listar_conductores") }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Actualizar Conductor
                    ConductorOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=15FOJM_4dWtDg3K436MAGCYkqUJlo8aDX&export=download", // Actualizar Conductor
                        label = "Actualizar Conductor",
                        onClick = { navController.navigate("actualizar_conductor") }
                    )
                    // Eliminar Conductor
                    ConductorOptionIcon(
                        imageUrl = "https://drive.usercontent.google.com/u/0/uc?id=1efUDIB3ez3ABYb2H32AG6eZYuqzmEDYE&export=download", // Eliminar Conductor
                        label = "Eliminar Conductor",
                        onClick = { navController.navigate("eliminar_conductor") }
                    )
                }
            }
        }
    }
}

@Composable
fun ConductorOptionIcon(imageUrl: String, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = label,
            modifier = Modifier
                .size(80.dp)
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
