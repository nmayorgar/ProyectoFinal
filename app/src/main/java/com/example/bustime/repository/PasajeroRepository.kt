package com.example.bustime.repository

import com.example.bustime.Interfaces.ApiService
import com.example.bustime.service.RetrofitClient
import com.example.bustime.Model.Pasajeros
import com.example.bustime.service.RetrofitClient.apiService
import javax.inject.Inject
import retrofit2.Response


class PasajeroRepository @Inject constructor(
    private val api: ApiService // Reemplaza con el nombre real de tu interfaz
) {

    suspend fun obtenerPasajeros(): List<Pasajeros> = api.obtenerPasajeros()

    suspend fun obtenerPasajeroPorId(id: Long): Pasajeros = api.obtenerPasajero(id)

    suspend fun guardarPasajero(pasajero: Pasajeros): Pasajeros = api.guardarPasajero(pasajero)

    suspend fun actualizarPasajero(id: Long, pasajero: Pasajeros): Pasajeros {
        return apiService.actualizarPasajero(id, pasajero)
    }

    suspend fun eliminarPasajero(id: Long): Response<Unit> {
        return apiService.eliminarPasajero(id)
    }

}
