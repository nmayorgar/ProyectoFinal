package com.example.bustime.repository

import com.example.bustime.Interfaces.ApiService
import com.example.bustime.Model.Conductor

class ConductorRepository(private val api: ApiService)  {

    suspend fun obtenerConductores(): List<Conductor> {
        return try {
            api.obtenerConductores()
        } catch (e: Exception) {
            println("Error al obtener conductores: ${e.message}")
            emptyList()
        }
    }

    suspend fun obtenerConductorPorId(id: Long): Conductor? {
        return try {
            api.obtenerConductor(id)
        } catch (e: Exception) {
            println("Error al obtener conductor por ID: ${e.message}")
            null
        }
    }

    suspend fun guardarConductor(conductor: Conductor) {
        try {
            api.guardarConductor(conductor)
            println("Conductor guardado correctamente")
        } catch (e: Exception) {
            println("Error al guardar conductor: ${e.message}")
        }
    }

    suspend fun actualizarConductor(id: Long, conductor: Conductor) {
        try {
            api.actualizarConductor(id, conductor) // Se usa el ID del conductor correctamente
            println("Conductor actualizado correctamente")
        } catch (e: Exception) {
            println("Error al actualizar conductor: ${e.message}")
        }
    }

    suspend fun eliminarConductor(id: Long) {
        try {
            api.eliminarConductor(id)
            println("Conductor eliminado correctamente")
        } catch (e: Exception) {
            println("Error al eliminar conductor: ${e.message}")
        }
    }
}