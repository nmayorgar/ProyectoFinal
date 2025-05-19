package com.example.bustime.repository

import com.example.bustime.Model.Ruta
import com.example.bustime.Interfaces.ApiService
import com.example.bustime.Interfaces.RetrofitClient

class RutaRepository(private val api: ApiService) {

    suspend fun obtenerRutas(): List<Ruta> {
        return api.obtenerRutas()
    }

    suspend fun obtenerRuta(id: Long): Ruta {
        return api.obtenerRuta(id)
    }

    suspend fun guardarRuta(ruta: Ruta) {
        api.guardarRuta(ruta)
    }

    suspend fun actualizarRuta(id: Long, ruta: Ruta) {
        try {
            api.actualizarRuta(id, ruta) // Debe recibir un Long y el objeto Ruta
        } catch (e: Exception) {
            println("Error al actualizar ruta: ${e.message}")
        }
    }

    suspend fun eliminarRuta(id: Long) {
        api.eliminarRuta(id)
    }
}