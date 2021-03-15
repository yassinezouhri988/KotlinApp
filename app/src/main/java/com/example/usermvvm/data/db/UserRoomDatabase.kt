package com.example.usermvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.usermvvm.data.db.dao.UserDao
import com.example.usermvvm.data.db.entities.User


@Database(
        entities =  arrayOf(User::class),
        version = 1,
        exportSchema = false
)
abstract class UserRoomDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        @Volatile
        private var instance: UserRoomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        UserRoomDatabase::class.java,
                        "MyDatabase.db"
                ).build()
    }
}
