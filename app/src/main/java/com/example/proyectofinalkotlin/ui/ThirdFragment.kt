package com.example.proyectofinalkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinalkotlin.R
import com.example.proyectofinalkotlin.databinding.FragmentThirdBinding
import com.example.proyectofinalkotlin.model.pojo.RickMorty
import com.example.proyectofinalkotlin.viewModel.RickViewModel

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    private val viewModel: RickViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FavoritesAdapter()
        binding.rvFavorites.adapter = adapter
        binding.rvFavorites.layoutManager = LinearLayoutManager(context)

        viewModel.listFavImages().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })
    }

}