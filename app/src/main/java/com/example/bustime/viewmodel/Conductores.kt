package com.example.bustime.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bustime.Model.Conductor
import com.example.bustime.repository.ConductorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.bustime.Interfaces.RetrofitClient // Importa RetrofitClient

class ConductoresViewModel : ViewModel() {

    private val repository = ConductorRepository(RetrofitClient.apiService) // Pasa la instancia de ApiService

    private val _listaConductores = MutableStateFlow<List<Conductor>>(emptyList())
    val listaConductores: StateFlow<List<Conductor>> = _listaConductores

    init {
        obtenerConductores()
    }


    fun obtenerConductores() {
        viewModelScope.launch {
            try {
                val lista = repository.obtenerConductores()
                _listaConductores.value = lista
            } catch (e: Exception) {
                println("Error al obtener conductores: ${e.message}")
            }
        }
    }

    fun guardarConductor(conductor: Conductor) {
        viewModelScope.launch {
            try {
                repository.guardarConductor(conductor)
                obtenerConductores()
            } catch (e: Exception) {
                println("Error al guardar conductor: ${e.message}")
            }
        }
    }

    fun actualizarConductor(conductor: Conductor) {
        viewModelScope.launch {
            try {
                repository.actualizarConductor(conductor.id_conductor.toLong(), conductor)
                obtenerConductores()
            } catch (e: Exception) {
                println("Error al actualizar conductor: ${e.message}")
            }
        }
    }

    fun eliminarConductor(id: Long) {
        viewModelScope.launch {
            try {
                repository.eliminarConductor(id)
                obtenerConductores()
            } catch (e: Exception) {
                println("Error al eliminar conductor: ${e.message}")
            }
        }
    }
}
