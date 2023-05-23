package com.beto.myapplication.repositories

import com.beto.myapplication.model.TiendaModel

class TiendaRepository(val tiendas: MutableList<TiendaModel>) {
    fun getAll() = tiendas
    fun insertTienda(tienda: TiendaModel) {
        tiendas.add(tienda)
    }
}