package com.example.bustime.Model

import com.google.gson.annotations.SerializedName

data class Pasajeros(
    val id_pasajero: Long,
    val nombre: String,
    val correo: String,
    val telefono: String,
    val id_ruta: Long // ⚠️ Se requiere este campo
)