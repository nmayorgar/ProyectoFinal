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
fun EliminarAutobusScreen(
    navController: NavHostController,
    idAutobus: Long,
    viewModel: AutobusViewModel
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Eliminar Autobús") }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                "¿Seguro que deseas eliminar este autobús?",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = {
                    viewModel.eliminarAutobus(idAutobus)
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
