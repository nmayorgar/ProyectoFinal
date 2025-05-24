package com.example.bustime.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bustime.Model.Autobus
import com.example.bustime.Model.Conductor
import com.example.bustime.viewmodel.AutobusViewModel

@Composable
fun ActualizarAutobusScreen(
    navController: NavHostController,
    idAutobus: Long,
    viewModel: AutobusViewModel
) {
    val lista by viewModel.autobuses.collectAsState()
    val autobus = lista.find { it.id_bus == idAutobus }

    var placa by remember { mutableStateOf(autobus?.placa ?: "") }
    var modelo by remember { mutableStateOf(autobus?.modelo ?: "") }
    var capacidad by remember { mutableStateOf(autobus?.capacidad?.toString() ?: "") }
    val conductor = autobus?.conductor ?: Conductor(0, "", "", "")

    if (autobus == null) {
        Text("Autobús no encontrado")
        return
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Actualizar Autobús", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = placa,
            onValueChange = { placa = it },
            label = { Text("Placa") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = modelo,
            onValueChange = { modelo = it },
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = capacidad,
            onValueChange = { capacidad = it.filter { char -> char.isDigit() } },
            label = { Text("Capacidad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val actualizado = autobus.copy(
                placa = placa,
                modelo = modelo,
                capacidad = capacidad.toIntOrNull() ?: autobus.capacidad,
                conductor = conductor
            )
            viewModel.actualizarAutobus(actualizado)
            navController.popBackStack()
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Guardar Cambios")
        }
    }
}
