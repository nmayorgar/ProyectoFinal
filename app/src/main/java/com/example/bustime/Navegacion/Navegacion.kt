package com.example.bustime.Navegacion

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bustime.Screen.*
import com.example.bustime.pantallas.conductores.ActualizarConductorScreen
import com.example.bustime.pantallas.conductores.AgregarConductorScreen
import com.example.bustime.pantallas.conductores.ListarConductoresScreen
import com.example.bustime.pantallas.pasajeros.AgregarPasajero
import com.example.bustime.pantallas.pasajeros.ListarPasajerosScreen
import com.example.bustime.screen.ActualizarAutobusScreen
import com.example.bustime.screen.AgregarAutobusScreen
import com.example.bustime.screen.EliminarAutobusScreen
import com.example.bustime.screen.ListarAutobusesScreen
import com.example.bustime.viewmodel.*


@Composable
fun AppNavHost(navController: NavHostController) {
    val pasajeroViewModel: PasajeroViewModel = hiltViewModel()
    val rutaViewModel: RutaViewModel = hiltViewModel() // Instancia única compartida

    NavHost(navController = navController, startDestination = "inicio") {

        composable("inicio") {
            PantallaInicio(navController)
        }

        composable("pasajeros") {
            PantallaPasajeros(navController, pasajeroViewModel)
        }

        composable("agregar_pasajeros") {
            AgregarPasajero(navController, pasajeroViewModel, rutaViewModel)
        }

        composable(
            "actualizar_pasajero/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: 0L
            ActualizarPasajeroScreen(navController, id, pasajeroViewModel, rutaViewModel)
        }

        composable("listar_pasajeros") {
            ListarPasajerosScreen(navController, pasajeroViewModel)
        }

        composable(
            "eliminar_pasajero/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: 0L
            EliminarPasajeroScreen(navController, id, pasajeroViewModel)
        }

        composable("conductores") {
            val viewModel: ConductoresViewModel = hiltViewModel()
            PantallaConductores(navController, viewModel)
        }
        composable("agregar_conductor") {
            val viewModel: ConductoresViewModel = hiltViewModel()
            AgregarConductorScreen(navController, viewModel)
        }


        composable("actualizar_conductor") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull() ?: return@composable
            val viewModel: ConductoresViewModel = hiltViewModel()
            ActualizarConductorScreen(navController, idConductor = id, viewModel)
        }

        composable("eliminar_conductor") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull() ?: return@composable
            val viewModel: ConductoresViewModel = hiltViewModel()
            EliminarConductorScreen(navController, idConductor = id, viewModel)
        }


        composable("listar_conductores") {
            val viewModel: ConductoresViewModel = hiltViewModel()
            ListarConductoresScreen(navController, viewModel)
        }

        composable("listarAutobuses") {
      //      ListarAutobusesScreen(navController, autobusViewModel)
        }
        composable("agregarAutobus") {
      //      AgregarAutobusScreen(navController, autobusViewModel)
        }
        composable("actualizarAutobus/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            id?.let {
      //          ActualizarAutobusScreen(navController, autobusViewModel, it)
            }
        }
        composable("eliminarAutobus/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            id?.let {
     //           EliminarAutobusScreen(navController, it, autobusViewModel)
            }
        }


        composable("pantalla_rutas") {
            PantallaRuta(navController, rutaViewModel)
        }
    }
}
