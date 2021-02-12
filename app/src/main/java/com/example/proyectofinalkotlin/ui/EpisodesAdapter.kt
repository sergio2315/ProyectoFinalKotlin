package com.example.proyectofinalkotlin.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectofinalkotlin.databinding.RickItemListBinding
import com.example.proyectofinalkotlin.model.pojo.RickMorty

class EpisodesAdapter:RecyclerView.Adapter<EpisodesAdapter.EpisodesAdapterVH>() {
    private var listCharacter = listOf<RickMorty>()
    private val selectedCharacter = MutableLiveData<RickMorty>()
    private val selectedFav = MutableLiveData<RickMorty>()

    fun selectedFavorite() = selectedFav
    fun selectedItem() = selectedCharacter
    fun update(list: List<RickMorty>){
        listCharacter = list
        notifyDataSetChanged()
    }
    inner class EpisodesAdapterVH(private val binding: RickItemListBinding)
        : RecyclerView.ViewHolder(binding.root),View.OnClickListener,View.OnLongClickListener{
        fun bind(rickMorty: RickMorty){
            Glide.with(binding.imageView).load(rickMorty.image).centerCrop().into(binding.imageView)
            itemView.setOnClickListener(this)

            if (rickMorty.favorite){
                binding.ivFavorite.setColorFilter(Color.RED)
            }else{
                binding.ivFavorite.setColorFilter(Color.GRAY)
            }
            itemView.setOnLongClickListener(this)
        }
        override fun onClick(v: View?) {
            selectedItem().value = listCharacter[adapterPosition]
        }

        override fun onLongClick(v: View?): Boolean {
            selectedFavorite().value = listCharacter[adapterPosition]
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesAdapterVH {
        return EpisodesAdapterVH(RickItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: EpisodesAdapterVH, position: Int) {
        val episodes = listCharacter[position]
        holder.bind(episodes)
    }
    override fun getItemCount(): Int = listCharacter.size
}