package com.beto.myapplication

import android.app.Application
import com.beto.myapplication.data.tiendas
import com.beto.myapplication.repositories.TiendaRepository

class TiendaTrackerApplication: Application() {
    val repository = TiendaRepository(tiendas)
}