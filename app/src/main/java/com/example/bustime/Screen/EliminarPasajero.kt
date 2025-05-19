package com.example.bustime.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bustime.viewmodel.PasajerosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EliminarPasajeroScreen(navController: NavHostController, pasajeroId: Long, pasajerosViewModel: PasajerosViewModel) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Eliminar Pasajero") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).padding(16.dp).fillMaxSize()
        ) {
            Text("¿Seguro que deseas eliminar este pasajero?", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = {
                    pasajerosViewModel.eliminarPasajero(pasajeroId)
                    navController.popBackStack()
                }) {
                    Text("Eliminar")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { navController.popBackStack() }) {
                    Text("Cancelar")
                }
            }
        }
    }
}