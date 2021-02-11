package com.example.proyectofinalkotlin.model.remote

import com.example.proyectofinalkotlin.model.pojo.ResponseCharacter
import com.example.proyectofinalkotlin.model.pojo.RickMorty
import retrofit2.Response
import retrofit2.http.GET

interface RickMortyApi {
    @GET("character")
    suspend fun fetchImagesRickMortyCoroutines(): Response<ResponseCharacter>
}