package com.example.proyectofinalkotlin.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "rickMorty_table")
data class RickMorty(@PrimaryKey val id: Int,
                     @SerializedName("image")
                     val image: String,
                     @SerializedName("name")
                     val name: String,
                     @SerializedName("species")
                     val species: String,
                     @SerializedName("status")
                     val status: String,
                     var favorite: Boolean = false)