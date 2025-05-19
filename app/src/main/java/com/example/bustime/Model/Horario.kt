package com.example.bustime.Model

import java.time.LocalTime

data class Horario(
    val id_horario: Long,
    val salida: LocalTime,
    val llegada: LocalTime,
    val dia_semana: String,
    val ruta: Ruta,
    val bus: Autobus
)