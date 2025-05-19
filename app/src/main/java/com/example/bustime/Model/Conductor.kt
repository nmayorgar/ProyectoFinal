package com.example.bustime.Model

import com.google.gson.annotations.SerializedName

data class Conductor(
    @SerializedName("id") val id_conductor: Long,
    val nombre: String,
    val licencia: String,
    val telefono: String
)
