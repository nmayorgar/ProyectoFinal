package com.example.bustime.Screen

import androidx.compose.foundation.clickable
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
import com.example.bustime.viewmodel.PasajeroViewModel
import com.example.bustime.viewmodel.RutaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActualizarPasajeroScreen(
    navController: NavHostController,
    pasajeroId: Long,
    pasajeroViewModel: PasajeroViewModel,
    rutaViewModel: RutaViewModel
) {
    val rutas by rutaViewModel.listaRutas.collectAsState()
    val pasajero by pasajeroViewModel.pasajeroSeleccionado.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var rutaSeleccionada by remember { mutableStateOf<Ruta?>(null) }

    // Cargar pasajero y rutas
    LaunchedEffect(pasajeroId) {
        pasajeroViewModel.obtenerPasajeroPorId(pasajeroId)
        rutaViewModel.cargarRutas()
    }

    // Rellenar campos al cargar pasajero
    LaunchedEffect(pasajero) {
        pasajero?.let {
            nombre = it.nombre
            correo = it.correo
            telefono = it.telefono
            rutaSeleccionada = rutas.find { ruta -> ruta.id_ruta == it.rutas?.id_ruta }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Actualizar Pasajero") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Selecciona una Ruta", style = MaterialTheme.typography.titleMedium)

            DropdownMenuRutas(
                rutas = rutas,
                selectedRuta = rutaSeleccionada,
                onRutaSeleccionada = { rutaSeleccionada = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (nombre.isNotBlank() && correo.isNotBlank() && telefono.isNotBlank()) {
                        val pasajeroActualizado = Pasajeros(
                            id_pasajero = pasajeroId,
                            nombre = nombre,
                            correo = correo,
                            telefono = telefono,
                            rutas = rutaSeleccionada
                        )
                        pasajeroViewModel.actualizarPasajero(pasajeroActualizado)
                        navController.popBackStack()
                    }
                },
                enabled = rutaSeleccionada != null
            ) {
                Text("Actualizar Pasajero")
            }
        }
    }
}

@Composable
fun DropdownMenuRutas(
    rutas: List<Ruta>,
    selectedRuta: Ruta?,
    onRutaSeleccionada: (Ruta) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selectedRuta?.let { "${it.origen} - ${it.destino}" } ?: "",
            onValueChange = {},
            label = { Text("Ruta") },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            rutas.forEach { ruta ->
                DropdownMenuItem(
                    text = { Text("${ruta.origen} - ${ruta.destino}") },
                    onClick = {
                        onRutaSeleccionada(ruta)
                        expanded = false
                    }
                )
            }
        }
    }
}
