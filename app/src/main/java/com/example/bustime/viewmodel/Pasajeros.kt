package com.example.bustime.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bustime.Model.Pasajeros
import com.example.bustime.repository.PasajerosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasajerosViewModel @Inject constructor(
    private val repository: PasajerosRepository
) : ViewModel() {

    private val _listaPasajeros = MutableStateFlow<List<Pasajeros>>(emptyList())
    val listaPasajeros: StateFlow<List<Pasajeros>> = _listaPasajeros

    private val _pasajeroSeleccionado = MutableStateFlow<Pasajeros?>(null)
    val pasajeroSeleccionado: StateFlow<Pasajeros?> = _pasajeroSeleccionado

    init {
        cargarPasajeros()
        obtenerPasajeros()

    }

    fun cargarPasajeros() {
        viewModelScope.launch {
            try {
                val pasajeros = repository.obtenerPasajeros()
                // Actualiza solo si hay cambios para no refrescar innecesariamente
                if (pasajeros != _listaPasajeros.value) {
                    _listaPasajeros.value = pasajeros
                }
            } catch (e: Exception) {
                Log.e("PasajerosViewModel", "Error al cargar pasajeros: ${e.message}")
            }
        }
    }

    fun obtenerPasajeros() {
        viewModelScope.launch {
            try {
                val pasajeros = repository.obtenerPasajeros()
                _listaPasajeros.value = pasajeros
            } catch (e: Exception) {
                println("Error al obtener pasajeros: ${e.message}")
            }
        }
    }

    fun obtenerPasajeroPorId(id: Long) {
        viewModelScope.launch {
            try {
                _pasajeroSeleccionado.value = repository.obtenerPasajeroPorId(id)
            } catch (e: Exception) {
                Log.e("PasajerosViewModel", "Error al obtener pasajero por ID: ${e.message}")
            }
        }
    }

    fun actualizarPasajero(pasajero: Pasajeros?) {
        if (pasajero == null) {
            Log.e("PasajerosViewModel", "Error: El pasajero no puede ser nulo")
            return
        }
        viewModelScope.launch {
            try {
                repository.actualizarPasajero(pasajero)
                cargarPasajeros()
                Log.d("PasajerosViewModel", "Pasajero actualizado correctamente")
            } catch (e: Exception) {
                Log.e("PasajerosViewModel", "Error al actualizar pasajero: ${e.message}")
            }
        }
    }

    fun eliminarPasajero(id: Long) {
        viewModelScope.launch {
            try {
                repository.eliminarPasajero(id)
                cargarPasajeros()
            } catch (e: Exception) {
                Log.e("PasajerosViewModel", "Error al eliminar pasajero: ${e.message}")
            }
        }
    }

    fun guardarPasajero(pasajero: Pasajeros) {
        viewModelScope.launch {
            try {
                repository.guardarPasajero(pasajero)
                cargarPasajeros()
            } catch (e: Exception) {
                Log.e("PasajerosViewModel", "Error al guardar pasajero: ${e.message}")
            }
        }
    }
}