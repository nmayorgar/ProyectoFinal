package com.example.bustime.pantallas.conductores

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bustime.Model.Conductor
import com.example.bustime.viewmodel.ConductoresViewModel

@Composable
fun AgregarConductorScreen(
    navController: NavController,
    viewModel: ConductoresViewModel
) {
    var nombre by remember { mutableStateOf("") }
    var licencia by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Agregar Conductor", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = licencia,
            onValueChange = { licencia = it },
            label = { Text("Licencia") },
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

        Button(
            onClick = {
                val nuevoConductor = Conductor(
                    id_conductor = 0L, // El backend lo asignará automáticamente
                    nombre = nombre,
                    licencia = licencia,
                    telefono = telefono
                )
                viewModel.guardarConductor(nuevoConductor)
                navController.popBackStack() // Regresa a la pantalla anterior
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Conductor")
        }
    }
}
