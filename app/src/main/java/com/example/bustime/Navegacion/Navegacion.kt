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
import com.example.bustime.viewmodel.*

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "inicio") {

        composable("inicio") {
            PantallaInicio(navController)
        }

        composable("pasajeros") {
            val pasajerosViewModel: PasajerosViewModel = hiltViewModel()
            PantallaPasajeros(navController, pasajerosViewModel)
        }

        composable("agregar_pasajeros") {
            val pasajerosViewModel: PasajerosViewModel = hiltViewModel()
            val rutaViewModel: RutaViewModel = hiltViewModel()
            AgregarPasajeroScreen(navController, pasajerosViewModel, rutaViewModel)
        }

        composable(
            "actualizar_pasajero/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: 0L
            val pasajerosViewModel: PasajerosViewModel = hiltViewModel()
            val rutaViewModel: RutaViewModel = hiltViewModel()
            ActualizarPasajeroScreen(navController, id, pasajerosViewModel, rutaViewModel)
        }

        composable("listar_pasajeros") {
            val pasajerosViewModel: PasajerosViewModel = hiltViewModel()
            ListarPasajerosScreen(navController, pasajerosViewModel)
        }

        composable(
            "eliminar_pasajero/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: 0L
            val pasajerosViewModel: PasajerosViewModel = hiltViewModel()
            EliminarPasajeroScreen(navController, id, pasajerosViewModel)
        }

        composable("conductores") {
            val viewModel: ConductoresViewModel = viewModel()
            PantallaConductores(navController, viewModel)
        }

        composable("pantalla_rutas") {
            val viewModel: RutaViewModel = viewModel()
            PantallaRuta(navController, viewModel)
        }
            }

        }


