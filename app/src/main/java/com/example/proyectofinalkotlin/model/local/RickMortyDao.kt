package com.example.proyectofinalkotlin.model.local
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyectofinalkotlin.model.pojo.RickMorty

@Dao
interface RickMortyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEpisodes(Episodeslist: List<RickMorty>)
   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllEpisodes(Episodeslist: RickMorty)*/

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImagesRickMorty(Imagelist: List<RickMorty>)*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImagesRickMorty(Imagelist: RickMorty)

    @Query("SELECT * FROM rickMorty_table")
    fun getAllRickMortyBD(): LiveData<List<RickMorty>>

    @Query("SELECT * FROM rickMorty_table")
    fun getAllImagesRickMortyBDById(): LiveData<List<RickMorty>>
}