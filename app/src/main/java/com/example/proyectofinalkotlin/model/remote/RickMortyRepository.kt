package com.example.proyectofinalkotlin.model.remote

import android.util.Log
import com.example.proyectofinalkotlin.model.local.RickMortyDao
import com.example.proyectofinalkotlin.model.pojo.ResponseCharacter
import com.example.proyectofinalkotlin.model.pojo.RickMorty

class RickMortyRepository(private val dao : RickMortyDao) {
    private val services= RetrofitClient.retrofitInstance()
    val liveDataDB = dao.getAllRickMortyBD()

    fun converter(listCharacters: ResponseCharacter):List<RickMorty>{
        val character: MutableList<RickMorty> = mutableListOf<RickMorty>()
        listCharacters.results.map { character.add(RickMorty
        (id = it.id, name = it.name,image = it.image,species = it.species,status = it.status)) }
        return character
    }

    suspend fun getRickMortyWithCourutines() {
        Log.d("REPOSITORY","Utilizando corrutinas")
        try {
            val response = RetrofitClient.retrofitInstance().fetchImagesRickMortyCoroutines()
            when(response.isSuccessful){
                true->response.body()?.let {
                    //aca se inserta en la base de datos
                    dao.insertAllCharacters(converter(it))
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()} ")
            }
        }catch (t: Throwable){
            Log.e("ERROR CORRUTINA",t.message.toString())
        }
    }
    // Actualizar datos
    suspend fun updateFavImages(rickMorty: RickMorty) {
        dao.updateRickMorty(rickMorty)
    }
}