package com.beto.myapplication.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beto.myapplication.databinding.FragmentTiendaItemBinding
import com.beto.myapplication.model.TiendaModel

class TiendaAdapter(val clickListener: (tienda: TiendaModel) -> Unit): RecyclerView.Adapter<TiendaAdapter.ViewHolder>() {
    // data para adapter
    val tiendas = ArrayList<TiendaModel>()

    // ViewHolder
    class ViewHolder(val binding: FragmentTiendaItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tienda: TiendaModel, clickListener: (tienda: TiendaModel) -> Unit) {
            //TODO bind data
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tiendas[position], clickListener)
    }

    override fun getItemCount(): Int {
        return tiendas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = FragmentTiendaItemBinding.inflate(inflater)
        return ViewHolder(view)
    }
}