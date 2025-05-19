package com.example.bustime.repository

import com.example.bustime.Model.Autobus
import com.example.bustime.Interfaces.RetrofitClient

class AutobusRepository {

    suspend fun obtenerAutobuses(): List<Autobus> {
        return RetrofitClient.apiService.obtenerAutobuses()
    }

    suspend fun obtenerAutobus(id: Long): Autobus {  // Aquí se usa Int en lugar de Long
        return RetrofitClient.apiService.obtenerAutobus(id)
    }

    suspend fun guardarAutobus(autobus: Autobus) {
        RetrofitClient.apiService.guardarAutobus(autobus)
    }

    suspend fun eliminarAutobus(id: Long) {  // Usamos Int
        RetrofitClient.apiService.eliminarAutobus(id)
    }

    suspend fun actualizarAutobus(id: Long, autobus: Autobus) {  // Usamos Int
        RetrofitClient.apiService.actualizarAutobus(id, autobus)
    }
}
