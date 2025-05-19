package com.example.bustime.Interfaces

import com.example.bustime.Model.Autobus
import com.example.bustime.Model.Conductor
import com.example.bustime.Model.Horario
import com.example.bustime.Model.Pasajeros
import com.example.bustime.Model.Ruta
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("autobuses")
    suspend fun obtenerAutobuses(): List<Autobus>

    @GET("autobuses/{id}")
    suspend fun obtenerAutobus(@Path("id") id: Long): Autobus  // Aquí usas Int

    @POST("autobuses")
    suspend fun guardarAutobus(@Body autobus: Autobus): Autobus

    @PUT("autobuses/{id}")
    suspend fun actualizarAutobus(@Path("id") id: Long, @Body autobus: Autobus): Autobus  // Aquí también Int

    @DELETE("autobuses/{id}")
    suspend fun eliminarAutobus(@Path("id") id: Long)  // Aquí también Int

    @GET("conductores")
    suspend fun obtenerConductores(): List<Conductor>

    @GET("conductores/{id}")
    suspend fun obtenerConductor(@Path("id") id: Long): Conductor

    @POST("conductores")
    suspend fun guardarConductor(@Body conductor: Conductor) // Se envía el objeto completo

    @PUT("conductores/{id}")
    suspend fun actualizarConductor(@Path("id") id: Long, @Body conductor: Conductor): Conductor

    @DELETE("conductores/{id}")
    suspend fun eliminarConductor(@Path("id") id: Long)

    @GET("horarios")
    suspend fun obtenerHorarios(): List<Horario>

    // Obtener un horario por su ID
    @GET("horarios/{id}")
    suspend fun obtenerHorario(@Path("id") id: Long): Horario

    // Guardar un nuevo horario
    @POST("horarios")
    suspend fun guardarHorario(@Body id: Long): Horario

    // Actualizar un horario existente
    @PUT("horarios/{id}")
    suspend fun actualizarHorario(@Path("id") id: Long, @Body horario: Horario): Horario

    // Eliminar un horario por ID
    @DELETE("horarios/{id}")
    suspend fun eliminarHorario(@Path("id") id: Long)

    @GET("pasajeros")
    suspend fun obtenerPasajeros(): List<Pasajeros>

    @GET("pasajeros/{id}")
    suspend fun obtenerPasajero(@Path("id") id: Long): Pasajeros

    @POST("pasajeros")
    suspend fun guardarPasajero(@Body pasajero: Pasajeros) // Se envía el objeto completo

    @PUT("pasajeros/{id}")
    suspend fun actualizarPasajero(@Path("id") id: Long, @Body pasajero: Pasajeros): Pasajeros

    @DELETE("pasajeros/{id}")
    suspend fun eliminarPasajero(@Path("id") id: Long)

    @GET("rutas")
    suspend fun obtenerRutas(): List<Ruta>

    @GET("rutas/{id}")
    suspend fun obtenerRuta(@Path("id") id: Long): Ruta

    @POST("rutas")
    suspend fun guardarRuta(@Body ruta: Ruta)

    @PUT("rutas/{id}")
    suspend fun actualizarRuta(@Path("id") id: Long, @Body ruta: Ruta)

    @DELETE("rutas/{id}")
    suspend fun eliminarRuta(@Path("id") id: Long)


}

object RetrofitClient {
    private const val BASE_URL = "http://192.168.100.15:8080/" // Cambiar esto según tu configuración

    // Inicializar Retrofit
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // URL base
            .addConverterFactory(GsonConverterFactory.create()) // Convertir JSON a objetos
            .build()
            .create(ApiService::class.java) // Crear instancia del ApiService
    }
}
