package com.beto.myapplication.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.beto.myapplication.R
import com.beto.myapplication.databinding.FragmentAddTiendaBinding
import com.beto.myapplication.ui.viewmodel.TiendaViewModel

class AddTiendaFragment : Fragment() {
    private lateinit var binding: FragmentAddTiendaBinding
    private val viewModel by activityViewModels<TiendaViewModel> {
        TiendaViewModel.Factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_tienda, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configBinding()
        addListener()
    }
    fun configBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
    fun addListener() {
        binding.actionAddTienda.setOnClickListener {
            viewModel.create()
            viewModel.clean()
            Toast.makeText(this.context, "Tienda agregada", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }
}