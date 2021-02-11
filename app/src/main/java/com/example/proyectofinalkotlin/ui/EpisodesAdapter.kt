package com.example.proyectofinalkotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinalkotlin.databinding.RickItemListBinding
import com.example.proyectofinalkotlin.model.pojo.RickMorty

class EpisodesAdapter:RecyclerView.Adapter<EpisodesAdapter.EpisodesAdapterVH>() {
    private var listEpisodes = listOf<RickMorty>()
    private val selectedEpisode = MutableLiveData<RickMorty>()

    fun selectedItem() = selectedEpisode
    fun update(list: List<RickMorty>){
        listEpisodes = list
        notifyDataSetChanged()
    }
    inner class EpisodesAdapterVH(private val binding: RickItemListBinding)
        : RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        fun bind(rickMorty: RickMorty){
            binding.textView1.text = rickMorty.name
            binding.textView2.text = "Episodio "+rickMorty.id.toString()
        }
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesAdapterVH {
        return EpisodesAdapterVH(RickItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: EpisodesAdapterVH, position: Int) {
        val episodes = listEpisodes[position]
        holder.bind(episodes)
    }
    override fun getItemCount(): Int = listEpisodes.size
}