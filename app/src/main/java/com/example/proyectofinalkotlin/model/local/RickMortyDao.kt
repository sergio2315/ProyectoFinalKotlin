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

    @Query("SELECT * FROM rickMorty_table")
    fun getAllImagesRickMortyBDById(): LiveData<List<RickMorty>>

    @Update
    suspend fun updateRickMorty(rickMorty: RickMorty)

    @Query("SELECT * FROM rickMorty_table")
    fun getAllFavoritesImages(): LiveData<List<RickMorty>>
}