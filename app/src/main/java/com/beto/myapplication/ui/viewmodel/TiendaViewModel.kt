package com.beto.myapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.beto.myapplication.TiendaTrackerApplication
import com.beto.myapplication.model.TiendaModel
import com.beto.myapplication.repositories.TiendaRepository

class TiendaViewModel(val repository: TiendaRepository): ViewModel() {
    var nombre = MutableLiveData("")
    var direccion = MutableLiveData("")
    fun getAll() = repository.getAll()
    fun create() {
        val tienda = TiendaModel(nombre.value.toString(), direccion.value.toString())
        repository.insertTienda(tienda)
    }
    fun clean() {
        nombre.value = ""
        direccion.value = ""
    }
    fun setTienda(tienda: TiendaModel) {
        nombre.value = tienda.nombre
        direccion.value = tienda.direccion
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TiendaTrackerApplication
                TiendaViewModel(app.repository)
            }
        }
    }
}