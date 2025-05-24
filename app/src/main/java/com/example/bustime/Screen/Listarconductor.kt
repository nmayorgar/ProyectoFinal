package com.example.bustime.pantallas.conductores

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bustime.viewmodel.ConductoresViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListarConductoresScreen(
    navController: NavHostController,
    viewModel: ConductoresViewModel
) {
    val conductores by viewModel.listaConductores.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Conductores") }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ) {
            if (conductores.isEmpty()) {
                Text(
                    text = "No hay conductores registrados",
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(conductores) { conductor ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text("Nombre: ${conductor.nombre}")
                                Text("Licencia: ${conductor.licencia}")
                                Text("Teléfono: ${conductor.telefono}")
                            }
                        }
                    }
                }
            }
        }
    }
}
