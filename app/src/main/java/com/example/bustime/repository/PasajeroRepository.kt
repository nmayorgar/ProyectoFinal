package com.example.bustime.repository

import com.example.bustime.Interfaces.ApiService
import com.example.bustime.Model.Pasajeros
import javax.inject.Inject // ✅ Importa la anotación

class PasajerosRepository @Inject constructor(private val api: ApiService) { // ✅ Agregado @Inject

    suspend fun obtenerPasajeros(): List<Pasajeros> {
        return try {
            api.obtenerPasajeros()
        } catch (e: Exception) {
            println("Error al obtener pasajeros: ${e.message}")
            emptyList()
        }
    }

    suspend fun obtenerPasajeroPorId(id: Long): Pasajeros? {
        return try {
            api.obtenerPasajero(id)
        } catch (e: Exception) {
            println("Error al obtener pasajero por ID: ${e.message}")
            null
        }
    }

    suspend fun guardarPasajero(pasajero: Pasajeros) {
        try {
            api.guardarPasajero(pasajero)
            println("Pasajero guardado correctamente")
        } catch (e: Exception) {
            println("Error al guardar pasajero: ${e.message}")
        }
    }

    suspend fun actualizarPasajero(pasajero: Pasajeros) {
        try {
            api.actualizarPasajero(pasajero.id_pasajero, pasajero) // Se usa id_pasajero del objeto
            println("Pasajero actualizado correctamente")
        } catch (e: Exception) {
            println("Error al actualizar pasajero: ${e.message}")
        }
    }

    suspend fun eliminarPasajero(id: Long) {
        try {
            api.eliminarPasajero(id)
            println("Pasajero eliminado correctamente")
        } catch (e: Exception) {
            println("Error al eliminar pasajero: ${e.message}")
        }
    }
}