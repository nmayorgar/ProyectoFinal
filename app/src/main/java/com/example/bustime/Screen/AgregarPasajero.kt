package com.example.bustime.pantallas.pasajeros

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bustime.Model.Pasajeros
import com.example.bustime.Model.Ruta
import com.example.bustime.viewmodel.PasajeroViewModel
import com.example.bustime.viewmodel.RutaViewModel

@Composable
fun AgregarPasajero(
    navController: NavController,
    pasajeroViewModel: PasajeroViewModel,
    rutaViewModel: RutaViewModel
) {
    val rutas by rutaViewModel.listaRutas.collectAsState()
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    var rutaSeleccionada by remember { mutableStateOf<Ruta?>(null) }
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        rutaViewModel.cargarRutas()
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
    ) {
        Text(
            text = "Registrar Pasajero",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Seleccionar Ruta (opcional)")

        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(rutaSeleccionada?.let { "${it.origen} - ${it.destino}" } ?: "Sin ruta asignada")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Sin ruta") },
                    onClick = {
                        rutaSeleccionada = null
                        expanded = false
                    }
                )
                rutas.forEach { ruta ->
                    DropdownMenuItem(
                        text = { Text("${ruta.origen} - ${ruta.destino}") },
                        onClick = {
                            rutaSeleccionada = ruta
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val pasajero = Pasajeros(
                    id_pasajero = 0L, // o null si tu API lo requiere
                    nombre = nombre,
                    correo = correo,
                    telefono = telefono,
                    rutas = rutaSeleccionada?.let { Ruta(id_ruta = it.id_ruta) }
                )
                pasajeroViewModel.guardarPasajero(pasajero)
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Pasajero")
        }
    }
}
