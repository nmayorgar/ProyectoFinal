package com.example.bustime.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bustime.Model.Pasajeros
import com.example.bustime.viewmodel.PasajerosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListarPasajerosScreen(navController: NavHostController, pasajerosViewModel: PasajerosViewModel) {
    val pasajeros by pasajerosViewModel.listaPasajeros.collectAsState()

    LaunchedEffect(Unit) {
        pasajerosViewModel.cargarPasajeros()
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Lista de Pasajeros") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).padding(16.dp).fillMaxSize()
        ) {
            LazyColumn {
                items(pasajeros) { pasajero ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate("actualizar_pasajero/${pasajero.id_pasajero}") }
                            .padding(16.dp)
                    ) {
                        Text(text = pasajero.nombre, style = MaterialTheme.typography.bodyLarge)
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = { navController.navigate("eliminar_pasajero/${pasajero.id_pasajero}") }) {
                            Text("Eliminar")
                        }
                    }
                }
            }
        }
    }
}