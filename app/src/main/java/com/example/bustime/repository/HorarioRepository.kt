package com.example.bustime.repository

import com.example.bustime.Model.Horario
import com.example.bustime.service.RetrofitClient

class HorarioRepository {

    suspend fun obtenerHorarios(): List<Horario> {
        return RetrofitClient.apiService.obtenerHorarios()
    }

    suspend fun obtenerHorario(id: Long): Horario {
        return RetrofitClient.apiService.obtenerHorario(id)
    }

    suspend fun guardarHorario(horario: Horario): Horario {
        return RetrofitClient.apiService.guardarHorario(horario)
    }

    suspend fun eliminarHorario(id: Long) {
        RetrofitClient.apiService.eliminarHorario(id)
    }

    suspend fun actualizarHorario(id: Long, horario: Horario) {
        RetrofitClient.apiService.actualizarHorario(id, horario)
    }
}
