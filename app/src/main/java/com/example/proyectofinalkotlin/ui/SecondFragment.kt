package com.example.proyectofinalkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.proyectofinalkotlin.R
import com.example.proyectofinalkotlin.databinding.FragmentSecondBinding
import com.example.proyectofinalkotlin.viewModel.RickViewModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: RickViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                Glide.with(binding.imageView2).load(it.image).into(binding.imageView2)
                binding.textView1.text = "Nombre: "+it.name
                binding.textView2.text = "Especie: "+it.species
                binding.textView3.text = "Estatus: "+it.status
            }
        })
        view.findViewById<Button>(R.id.btnReturn).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}