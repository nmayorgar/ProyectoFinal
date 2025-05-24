package com.example.bustime.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bustime.Model.Pasajeros
import com.example.bustime.repository.PasajeroRepository
import com.example.bustime.service.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import retrofit2.Response

@HiltViewModel
class PasajeroViewModel @Inject constructor(
    private val repository: PasajeroRepository
) : ViewModel() {

    private val _listaPasajeros = MutableStateFlow<List<Pasajeros>>(emptyList())
    val listaPasajeros: StateFlow<List<Pasajeros>> = _listaPasajeros

    private val _pasajeroSeleccionado = MutableStateFlow<Pasajeros?>(null)
    val pasajeroSeleccionado: StateFlow<Pasajeros?> = _pasajeroSeleccionado


    init {
        cargarPasajeros()
    }

    fun cargarPasajeros() {
        viewModelScope.launch {
            try {
                val pasajeros = RetrofitClient.apiService.obtenerPasajeros()
                _listaPasajeros.value = pasajeros
            } catch (e: Exception) {
                println("Error al cargar pasajeros: ${e.message}")
            }
        }
    }


    fun obtenerPasajeroPorId(id: Long) {
        viewModelScope.launch {
            try {
                val pasajero = repository.obtenerPasajeroPorId(id)
                _pasajeroSeleccionado.value = pasajero
            } catch (e: Exception) {
                Log.e("PasajeroViewModel", "Error al obtener pasajero por ID: ${e.message}")
            }
        }
    }

    fun guardarPasajero(pasajero: Pasajeros) {
        viewModelScope.launch {
            try {
                repository.guardarPasajero(pasajero)
                cargarPasajeros()
                Log.d("PasajeroViewModel", "Pasajero guardado correctamente")
            } catch (e: Exception) {
                Log.e("PasajeroViewModel", "Error al guardar pasajero: ${e.message}")
            }
        }
    }

    fun actualizarPasajero(pasajero: Pasajeros) {
        if (pasajero.id_pasajero == null) return
        viewModelScope.launch {
            try {
                repository.actualizarPasajero(pasajero.id_pasajero, pasajero)
                cargarPasajeros()
            } catch (e: Exception) {
                Log.e("PasajeroViewModel", "Error al actualizar pasajero: ${e.message}")
            }
        }
    }


    fun eliminarPasajero(id: Long) {
        viewModelScope.launch {
            try {
                val response = repository.eliminarPasajero(id)
                if (response.isSuccessful) {
                    Log.d("PasajeroViewModel", "Pasajero eliminado correctamente")
                    cargarPasajeros()
                } else {
                    Log.e("PasajeroViewModel", "Error HTTP ${response.code()}: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("PasajeroViewModel", "Excepción al eliminar pasajero", e)
            }
        }
    }

}

