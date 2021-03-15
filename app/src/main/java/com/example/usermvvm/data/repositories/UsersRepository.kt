package com.example.usermvvm.data.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.usermvvm.data.db.UserRoomDatabase
import com.example.usermvvm.data.db.entities.User
import com.example.usermvvm.data.network.api.SafeApiRequest
import com.example.usermvvm.data.network.api.UserApi
import com.example.usermvvm.data.network.models.UserResponse
import com.example.usermvvm.util.Coroutines
import com.example.usermvvm.util.PreferenceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import java.lang.Exception
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

private val MINIMUM_INTERVAL = 6

@RequiresApi(Build.VERSION_CODES.O)
class UsersRepository(
        private val api: UserApi,
        private val db: UserRoomDatabase,
        private val prefs: PreferenceProvider
) : SafeApiRequest() {


    private val users = MutableLiveData<List<User>>()
    init {
        users.observeForever {
            saveUsers(it)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun saveUsers(users: List<User>) {
        Coroutines.io {
            //prefs.savelastSavedAt( LocalDateTime.now().toString())
            db.getUserDao().SaveAllUsers(users)
        }
    }

    suspend fun getUsers(): LiveData<List<User>> {
        return withContext(Dispatchers.IO) {
            fetchUsers()
            db.getUserDao().getAllUsers()
        }
    }

    private suspend fun fetchUsers() {
        val lastSavedAt = prefs.getLastSavedAt()

        if (lastSavedAt == null || isFetchNeeded(LocalDateTime.parse(lastSavedAt))) {
            try {
                val response = apiRequest { api.getUsers() }
                db.getUserDao().deleteAll()
                users.postValue(response.users)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun isFetchNeeded(savedAt: LocalDateTime): Boolean {
        return ChronoUnit.HOURS.between(savedAt, LocalDateTime.now()) > MINIMUM_INTERVAL
    }

}

