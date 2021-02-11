package com.example.proyectofinalkotlin.model.pojo


import com.google.gson.annotations.SerializedName

data class ResponseCharacter(
    @SerializedName("results")
    val results: List<Result>
)