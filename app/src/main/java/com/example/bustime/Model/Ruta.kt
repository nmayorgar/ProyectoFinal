package com.example.bustime.Model

import com.google.gson.annotations.SerializedName

data class Ruta(
    val id_ruta: Long?,
    val origen: String? = null,
    val destino: String? = null,
    val distancia_km: String? = null,
    val duracion: String? = null
)
