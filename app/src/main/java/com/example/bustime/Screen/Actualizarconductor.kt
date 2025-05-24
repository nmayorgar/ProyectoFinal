package com.example.bustime.pantallas.conductores

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.bustime.Model.Conductor
import com.example.bustime.viewmodel.ConductoresViewModel

@Composable
fun ActualizarConductorScreen(
    navController: NavController,
    idConductor: Long,
    viewModel: ConductoresViewModel
) {
    val listaConductores by viewModel.listaConductores.collectAsState()
    val conductor = listaConductores.find { it.id_conductor == idConductor }

    var nombre by remember { mutableStateOf(conductor?.nombre ?: "") }
    var licencia by remember { mutableStateOf(conductor?.licencia ?: "") }
    var telefono by remember { mutableStateOf(conductor?.telefono ?: "") }

    if (conductor == null) {
        Text("Conductor no encontrado")
        return
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Actualizar Conductor", style = MaterialTheme.typography.titleLarge)
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
                val actualizado = conductor.copy(
                    nombre = nombre,
                    licencia = licencia,
                    telefono = telefono
                )
                viewModel.actualizarConductor(actualizado)
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Cambios")
        }
    }
}
