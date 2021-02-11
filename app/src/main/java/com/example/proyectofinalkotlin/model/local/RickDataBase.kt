package com.example.proyectofinalkotlin.model.local
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proyectofinalkotlin.model.pojo.RickMorty

@Database(entities = [RickMorty::class],version = 1)
abstract class RickDataBase: RoomDatabase() {
    abstract fun getRickDao(): RickMortyDao

    companion object {
        @Volatile
        private var INSTANCE : RickDataBase? = null

        fun getDataBase(context: Context): RickDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    RickDataBase::class.java, "rickDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}