@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bustime.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bustime.Model.Pasajeros
import com.example.bustime.Model.Ruta
import com.example.bustime.viewmodel.PasajerosViewModel
import com.example.bustime.viewmodel.RutaViewModel

@Composable
fun ActualizarPasajeroScreen(
    navController: NavHostController,
    pasajeroId: Long,
    pasajeroViewModel: PasajerosViewModel,
    rutaViewModel: RutaViewModel // ✅ Ya lo recibe correctamente
) {
    val rutas by rutaViewModel.listaRutas.collectAsState()
    // Implementación de la pantalla...

    val pasajero by pasajeroViewModel.pasajeroSeleccionado.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var rutaSeleccionada by remember { mutableStateOf<Ruta?>(null) }
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(pasajeroId) {
        pasajeroViewModel.obtenerPasajeroPorId(pasajeroId)
        rutaViewModel.obtenerRutas()
    }

    LaunchedEffect(pasajero) {
        pasajero?.let {
            nombre = it.nombre
            correo = it.correo
            telefono = it.telefono
            rutaSeleccionada = rutas.find { ruta -> ruta.id_ruta == it.id_ruta }
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Actualizar Pasajero") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).padding(16.dp).fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo") }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
            OutlinedTextField(value = telefono, onValueChange = { telefono = it }, label = { Text("Teléfono") }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))

            Spacer(modifier = Modifier.height(16.dp))

            Text("Selecciona una Ruta", style = MaterialTheme.typography.titleMedium)

            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
                OutlinedTextField(
                    value = rutaSeleccionada?.let { "${it.origen} - ${it.destino}" } ?: "Selecciona una ruta",
                    onValueChange = {},
                    modifier = Modifier.menuAnchor().fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
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
                    if (nombre.isNotBlank() && correo.isNotBlank() && telefono.isNotBlank() && rutaSeleccionada != null) {
                        val pasajeroActualizado = Pasajeros(pasajeroId, nombre, correo, telefono, rutaSeleccionada!!.id_ruta)
                        pasajeroViewModel.actualizarPasajero(pasajeroActualizado)
                        navController.popBackStack()
                    }
                },
                enabled = rutaSeleccionada != null
            ) { Text("Actualizar Pasajero") }
        }
    }
}