package com.example.proyectofinalkotlin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.proyectofinalkotlin.R
import com.example.proyectofinalkotlin.databinding.FragmentFirstBinding
import com.example.proyectofinalkotlin.viewModel.RickViewModel

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: RickViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharactersAdapter()
        binding.rvEpisodes.adapter = adapter
        binding.rvEpisodes.layoutManager =
            GridLayoutManager(context, 2) //LinearLayoutManager(context)

        viewModel.getRickList().observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("listado", it.toString())
                adapter.update(it)

                binding.btnFavorites.setOnClickListener {
                    findNavController().navigate(R.id.action_FirstFragment_to_thirdFragment)
                }
            }
        })
        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                viewModel.selected(it)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })
        adapter.selectedFavorite().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.favorite) {
                    it.favorite = false
                    viewModel.updateFavImages(it)
                    Toast.makeText(context, "Eliminado de favoritos", Toast.LENGTH_LONG).show()
                } else {
                    it.favorite = true
                    viewModel.updateFavImages(it)
                    Toast.makeText(context, "Añadido a favoritos", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}