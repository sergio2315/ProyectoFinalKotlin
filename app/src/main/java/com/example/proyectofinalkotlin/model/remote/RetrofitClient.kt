package com.example.proyectofinalkotlin.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val URI_BASE = "https://rickandmortyapi.com/api/"

        fun retrofitInstance(): RickMortyApi {
            val retrofit = Retrofit.Builder().baseUrl(URI_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RickMortyApi::class.java)
        }
    }
}