package com.example.proyectofinalkotlin.model.remote

import android.util.Log
import com.example.proyectofinalkotlin.model.local.RickMortyDao

class RickMortyRepository(private val dao : RickMortyDao) {
    private val services= RetrofitClient.retrofitInstance()
    val liveDataDB = dao.getAllRickMortyBD()

    suspend fun getRickMortyWithCourrutines() {
        Log.d("REPOSITORY","Utilizando corrutinas")
        try {
            val response = RetrofitClient.retrofitInstance().fetchRickMortyCorroutines()
            when(response.isSuccessful){
                true->response.body()?.let {
                    //aca se inserta en la base de datos
                    dao.insertAllEpisodes(it)
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()} ")
            }
        }catch (t: Throwable){
            Log.e("ERROR CORRUTINA",t.message.toString())
        }
    }
}