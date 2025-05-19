package com.example.bustime.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bustime.Model.Autobus
import com.example.bustime.repository.AutobusRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AutobusViewModel : ViewModel() {

    private val repository = AutobusRepository()

    private val _autobuses = MutableStateFlow<List<Autobus>>(emptyList())
    val autobuses: StateFlow<List<Autobus>> = _autobuses

    init {
        obtenerAutobuses()
    }

    fun obtenerAutobuses() {
        viewModelScope.launch {
            try {
                val lista = repository.obtenerAutobuses()
                _autobuses.value = lista
            } catch (e: Exception) {
                println("Error al obtener autobuses: ${e.message}")
            }
        }
    }

    fun guardarAutobus(autobus: Autobus) {
        viewModelScope.launch {
            try {
                repository.guardarAutobus(autobus)
                obtenerAutobuses()
            } catch (e: Exception) {
                println("Error al guardar autobús: ${e.message}")
            }
        }
    }

    fun actualizarAutobus(autobus: Autobus) {
        viewModelScope.launch {
            try {
                repository.actualizarAutobus(autobus.id_bus, autobus)
                obtenerAutobuses()
            } catch (e: Exception) {
                println("Error al actualizar autobús: ${e.message}")
            }
        }
    }

    fun eliminarAutobus(id: Long) {
        viewModelScope.launch {
            try {
                repository.eliminarAutobus(id)
                obtenerAutobuses()
            } catch (e: Exception) {
                println("Error al eliminar autobús: ${e.message}")
            }
        }
    }
}
