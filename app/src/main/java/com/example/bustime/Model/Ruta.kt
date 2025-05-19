package com.example.bustime.Model

import com.google.gson.annotations.SerializedName

data class Ruta(
    @SerializedName("id") val id_ruta: Long,
    val origen: String,
    val destino: String,
    val distancia_km: Double,
    val duracion: String
)
