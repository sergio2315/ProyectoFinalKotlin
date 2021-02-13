package com.example.proyectofinalkotlin.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.proyectofinalkotlin.model.pojo.RickMorty

@Dao
interface RickMortyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacters(Episodeslist: List<RickMorty>)

    @Query("SELECT * FROM rickMorty_table")
    fun getAllRickMortyBD(): LiveData<List<RickMorty>>

    @Update
    suspend fun updateRickMorty(rickMorty: RickMorty)

    @Query("SELECT * FROM rickMorty_table WHERE favorite = 1")
    fun getAllFavoritesImages(): LiveData<List<RickMorty>>
}