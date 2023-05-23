package com.beto.myapplication.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.beto.myapplication.R
import com.beto.myapplication.databinding.FragmentListTiendasBinding
import com.beto.myapplication.ui.viewmodel.TiendaViewModel

class ListTiendasFragment : Fragment() {
    private val viewModel by activityViewModels<TiendaViewModel> {
        TiendaViewModel.Factory
    }
    private lateinit var binding: FragmentListTiendasBinding
    private lateinit var adapter: TiendaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_tiendas, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configBinding()
        configAdapter()
        configRecyclerView()
        addListener()
    }
    fun addListener() {
        binding.newTiendaAction.setOnClickListener{
            findNavController().navigate(R.id.action_listTiendasFragment_to_addTiendaFragment)
        }
    }
    fun configBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
    }
    fun configAdapter() {
        adapter = TiendaAdapter {tienda->
            viewModel.setTienda(tienda)
            findNavController().navigate(R.id.action_listTiendasFragment_to_descriptionTiendaFragment)
        }
    }
    fun configRecyclerView() {
        binding.recyclerview.adapter = adapter
        showTiendas()
    }
    fun showTiendas() {
        val tiendas = viewModel.getAll()
        adapter.setData(tiendas)
    }
}