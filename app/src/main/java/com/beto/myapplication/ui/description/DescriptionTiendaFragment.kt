package com.beto.myapplication.ui.description

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.beto.myapplication.R
import com.beto.myapplication.databinding.FragmentDescriptionTiendaBinding
import com.beto.myapplication.ui.viewmodel.TiendaViewModel

class DescriptionTiendaFragment : Fragment() {
    private lateinit var binding : FragmentDescriptionTiendaBinding
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_description_tienda, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configBinding()
    }
    fun configBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clean()
    }
}