package com.example.bustime.repository

import com.example.bustime.Model.Autobus
import com.example.bustime.service.RetrofitClient

class AutobusRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun obtenerAutobuses(): List<Autobus> {
        return apiService.obtenerAutobuses()
    }

    suspend fun obtenerAutobus(id: Long): Autobus {
        return apiService.obtenerAutobus(id)
    }

    suspend fun guardarAutobus(autobus: Autobus): Autobus {
        return apiService.guardarAutobus(autobus)
    }

    suspend fun actualizarAutobus(id: Long, autobus: Autobus): Autobus {
        return apiService.actualizarAutobus(id, autobus)
    }

    suspend fun eliminarAutobus(id: Long) {
        apiService.eliminarAutobus(id)
    }
}
