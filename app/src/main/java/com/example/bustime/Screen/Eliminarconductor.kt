package com.example.bustime.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bustime.viewmodel.ConductoresViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EliminarConductorScreen(
    navController: NavHostController,
    idConductor: Long,
    conductoresViewModel: ConductoresViewModel
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Eliminar Conductor") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                "¿Seguro que deseas eliminar este conductor?",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = {
                    conductoresViewModel.eliminarConductor(idConductor)
                    navController.popBackStack()
                }) {
                    Text("Eliminar")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { navController.popBackStack() }) {
                    Text("Cancelar")
                }
            }
        }
    }
}
