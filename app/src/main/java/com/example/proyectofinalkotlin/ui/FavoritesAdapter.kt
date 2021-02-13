package com.example.proyectofinalkotlin.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectofinalkotlin.databinding.FavoritesItemListBinding
import com.example.proyectofinalkotlin.model.pojo.RickMorty

class FavoritesAdapter : RecyclerView.Adapter<FavoritesAdapter.FavoritesAdapterVH>() {
    private var listFavorites = listOf<RickMorty>()

    fun update(list: List<RickMorty>) {
        listFavorites = list
        notifyDataSetChanged()
    }

    inner class FavoritesAdapterVH(private val binding: FavoritesItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rickMorty: RickMorty) {
            Glide.with(binding.ivFavorite).load(rickMorty.image).into(binding.ivFavorite)
            binding.textView1.text = "Nombre: " + rickMorty.name
            binding.textView2.text = "Especie: " + rickMorty.species
            binding.textView3.text = "Estatus: " + rickMorty.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesAdapterVH {
        return FavoritesAdapterVH(FavoritesItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FavoritesAdapterVH, position: Int) {
        val favorites = listFavorites[position]
        holder.bind(favorites)
    }

    override fun getItemCount(): Int = listFavorites.size


}