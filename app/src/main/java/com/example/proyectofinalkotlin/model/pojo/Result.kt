package com.example.proyectofinalkotlin.model.pojo


import com.google.gson.annotations.SerializedName

data class Result(
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String
)