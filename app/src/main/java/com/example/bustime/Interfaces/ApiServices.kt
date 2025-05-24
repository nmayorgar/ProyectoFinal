package com.example.bustime.Interfaces

import com.example.bustime.Model.*
import retrofit2.http.*
import retrofit2.Response


interface ApiService {

    // PASAJEROS
    @GET("pasajeros")
    suspend fun obtenerPasajeros(): List<Pasajeros>

    @GET("pasajeros/{id}")
    suspend fun obtenerPasajero(@Path("id") id: Long): Pasajeros

    @POST("pasajeros")
    suspend fun guardarPasajero(@Body pasajero: Pasajeros): Pasajeros

    @PUT("pasajeros/{id}")
    suspend fun actualizarPasajero(@Path("id") id: Long, @Body pasajero: Pasajeros): Pasajeros

    @DELETE("pasajeros/{id}")
    suspend fun eliminarPasajero(@Path("id") id: Long): Response<Unit>


    // AUTOBUSES
    @GET("autobuses")
    suspend fun obtenerAutobuses(): List<Autobus>

    @GET("autobuses/{id}")
    suspend fun obtenerAutobus(@Path("id") id: Long): Autobus

    @POST("autobuses")
    suspend fun guardarAutobus(@Body autobus: Autobus): Autobus

    @PUT("autobuses/{id}")
    suspend fun actualizarAutobus(@Path("id") id: Long, @Body autobus: Autobus): Autobus

    @DELETE("autobuses/{id}")
    suspend fun eliminarAutobus(@Path("id") id: Long)


    // CONDUCTORES
    @GET("conductores")
    suspend fun obtenerConductores(): List<Conductor>

    @GET("conductores/{id}")
    suspend fun obtenerConductor(@Path("id") id: Long): Conductor

    @POST("conductores")
    suspend fun guardarConductor(@Body conductor: Conductor): Conductor

    @PUT("conductores/{id}")
    suspend fun actualizarConductor(@Path("id") id: Long, @Body conductor: Conductor): Conductor

    @DELETE("conductores/{id}")
    suspend fun eliminarConductor(@Path("id") id: Long)


    // HORARIOS
    @GET("horarios")
    suspend fun obtenerHorarios(): List<Horario>

    @GET("horarios/{id}")
    suspend fun obtenerHorario(@Path("id") id: Long): Horario

    @POST("horarios")
    suspend fun guardarHorario(@Body horario: Horario): Horario

    @PUT("horarios/{id}")
    suspend fun actualizarHorario(@Path("id") id: Long, @Body horario: Horario): Horario

    @DELETE("horarios/{id}")
    suspend fun eliminarHorario(@Path("id") id: Long)


    // RUTAS
    @GET("rutas")
    suspend fun obtenerRutas(): List<Ruta>

    @GET("rutas/{id}")
    suspend fun obtenerRuta(@Path("id") id: Long): Ruta

    @POST("rutas")
    suspend fun guardarRuta(@Body ruta: Ruta): Ruta

    @PUT("rutas/{id}")
    suspend fun actualizarRuta(@Path("id") id: Long, @Body ruta: Ruta): Ruta

    @DELETE("rutas/{id}")
    suspend fun eliminarRuta(@Path("id") id: Long)
}
