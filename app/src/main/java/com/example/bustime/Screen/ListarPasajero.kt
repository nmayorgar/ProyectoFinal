package com.example.bustime.pantallas.pasajeros

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bustime.viewmodel.PasajeroViewModel

@Composable
fun ListarPasajerosScreen(
    navController: NavController,
    pasajeroViewModel: PasajeroViewModel
) {
    val pasajeros by pasajeroViewModel.listaPasajeros.collectAsState()

    LaunchedEffect(Unit) {
        pasajeroViewModel.cargarPasajeros()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Lista de Pasajeros",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(pasajeros) { pasajero ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Nombre: ${pasajero.nombre}")
                        Text("Correo: ${pasajero.correo}")
                        Text("Teléfono: ${pasajero.telefono}")
                        pasajero.rutas?.let {
                            Text("Ruta: ${it.origen} - ${it.destino}")
                        }

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Button(onClick = {
                                navController.navigate("actualizar_pasajero/${pasajero.id_pasajero}")
                            }) {
                                Text("Editar")
                            }
                            Button(
                                onClick = {
                                    pasajero.id_pasajero?.let {
                                        pasajeroViewModel.eliminarPasajero(it)
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                            ) {
                                Text("Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }
}
