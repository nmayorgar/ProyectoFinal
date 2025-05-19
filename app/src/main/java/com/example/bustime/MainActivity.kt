package com.example.bustime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.bustime.Navegacion.AppNavHost
import dagger.hilt.android.AndroidEntryPoint // Importa Hilt

@AndroidEntryPoint // Se agrega esta anotación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavHost(navController = navController)
        }
    }
}