package com.example.bustime.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bustime.Model.Pasajeros
import com.example.bustime.Model.Ruta
import com.example.bustime.repository.RutaRepository
import com.example.bustime.service.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RutaViewModel : ViewModel() {

    private val repository = RutaRepository(RetrofitClient.apiService)

    private val _listaRutas = MutableStateFlow<List<Ruta>>(emptyList())
    val listaRutas: StateFlow<List<Ruta>> = _listaRutas

    init {
        obtenerRutas()
    }

    fun obtenerRutas() {
        viewModelScope.launch {
            try {
                val rutas = repository.obtenerRutas()
                _listaRutas.value = rutas
            } catch (e: Exception) {
                println("Error al obtener rutas: ${e.message}")
            }
        }
    }
    fun cargarRutas() {
        viewModelScope.launch {
            try {
                val rutas = repository.obtenerRutas()
                _listaRutas.value = rutas
            } catch (e: Exception) {
                Log.e("RutaViewModel", "Error al cargar rutas: ${e.message}")
            }
        }
    }
    fun guardarRuta(ruta: Ruta) {
        viewModelScope.launch {
            try {
                repository.guardarRuta(ruta)
                obtenerRutas()
            } catch (e: Exception) {
                println("Error al guardar ruta: ${e.message}")
            }
        }
    }

    fun actualizarRuta(ruta: Ruta) {
        viewModelScope.launch {
            try {
                ruta.id_ruta?.let { repository.actualizarRuta(it, ruta) } // Usa id_ruta del objeto correctamente
                obtenerRutas()
            } catch (e: Exception) {
                println("Error al actualizar ruta: ${e.message}")
            }
        }
    }


    fun eliminarRuta(id: Long) {
        viewModelScope.launch {
            try {
                repository.eliminarRuta(id)
                obtenerRutas()
            } catch (e: Exception) {
                println("Error al eliminar ruta: ${e.message}")
            }
        }
    }

}
