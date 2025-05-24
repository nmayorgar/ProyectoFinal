package com.example.bustime.Model

data class Autobus(
    val id_bus: Long,
    val placa: String,
    val modelo: String,
    val capacidad: Int,
    val conductor: Conductor
)
