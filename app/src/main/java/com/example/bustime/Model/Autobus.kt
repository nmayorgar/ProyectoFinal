package com.example.bustime.Model

data class Autobus(
    val id_bus: Long,  // Mantén el tipo Int
    val placa: String,
    val modelo: String,
    val capacidad: Int,
    val conductor: Conductor
)
