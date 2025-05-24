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
fun AgregarAutobusScreen(
    navController: NavHostController,
    viewModel: AutobusViewModel
) {
    var placa by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var capacidad by remember { mutableStateOf("") }
    // Suponemos que seleccionar conductor es otro proceso o predefinido
    // Por simplicidad aquí usaremos un conductor ficticio
    val conductor = Conductor(id_conductor = 1L, nombre = "Juan", licencia = "ABC123", telefono = "1234567890")

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Agregar Autobús", style = MaterialTheme.typography.titleLarge)

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
            val nuevoAutobus = Autobus(
                id_bus = 0L, // O se asigna en backend
                placa = placa,
                modelo = modelo,
                capacidad = capacidad.toIntOrNull() ?: 0,
                conductor = conductor
            )
            viewModel.guardarAutobus(nuevoAutobus)
            navController.popBackStack()
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Guardar")
        }
    }
}
