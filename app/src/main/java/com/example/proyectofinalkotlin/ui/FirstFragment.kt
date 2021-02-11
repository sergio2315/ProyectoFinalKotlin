package com.example.proyectofinalkotlin.ui

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinalkotlin.databinding.FragmentFirstBinding
import com.example.proyectofinalkotlin.viewModel.RickViewModel

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: RickViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = EpisodesAdapter()
        binding.rvEpisodes.adapter = adapter
        binding.rvEpisodes.layoutManager = LinearLayoutManager(context)

        viewModel.getRickList().observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("listado",it.toString())
                adapter.update(it)
            }
        })
    }
}