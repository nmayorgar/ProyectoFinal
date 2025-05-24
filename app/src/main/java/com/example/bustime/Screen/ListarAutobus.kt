package com.example.bustime.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bustime.viewmodel.AutobusViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListarAutobusesScreen(
    navController: NavHostController,
    viewModel: AutobusViewModel
) {
    val lista by viewModel.autobuses.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lista de Autobuses", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        lista.forEach { autobus ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "${autobus.placa} - ${autobus.modelo}")
                Row {
                    Button(onClick = {
                        navController.navigate("actualizar_autobus/${autobus.id_bus}")
                    }) {
                        Text("Actualizar")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        navController.navigate("eliminar_autobus/${autobus.id_bus}")
                    }) {
                        Text("Eliminar")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("agregar_autobus")
        }) {
            Text("Agregar Autobús")
        }
    }
}
