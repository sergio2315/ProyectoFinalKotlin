package com.example.proyectofinalkotlin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectofinalkotlin.model.local.RickDataBase
import com.example.proyectofinalkotlin.model.pojo.RickMorty
import com.example.proyectofinalkotlin.model.remote.RickMortyRepository
import kotlinx.coroutines.launch

class RickViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RickMortyRepository

    init {
        val dao = RickDataBase.getDataBase(application).getRickDao()
        repository = RickMortyRepository(dao)
        viewModelScope.launch {
            repository.getRickMortyWithCourutines()
        }
    }

    fun getRickList(): LiveData<List<RickMorty>> = repository.liveDataDB

    fun listFavImages(): LiveData<List<RickMorty>> = repository.listFavImages

    private val selectedCharacter: MutableLiveData<RickMorty> = MutableLiveData()
    fun selected(rickMorty: RickMorty?) {
        selectedCharacter.value = rickMorty
    }

    fun selectedItem(): LiveData<RickMorty> = selectedCharacter

    fun updateFavImages(rickMorty: RickMorty?) = viewModelScope.launch {
        if (rickMorty != null) {
            repository.updateFavImages(rickMorty)
        }
    }
}