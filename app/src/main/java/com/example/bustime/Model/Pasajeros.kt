package com.example.bustime.Model

data class Pasajeros(
    val id_pasajero: Long?=null,
    val nombre: String,
    val correo: String,
    val telefono: String,
    val rutas: Ruta? = null
)