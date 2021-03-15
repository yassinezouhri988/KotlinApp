package com.example.usermvvm.ui.user

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usermvvm.data.repositories.UsersRepository

@Suppress("UNCHECKED_CAST")
class UsersViewModelFactory(
    private val repository: UsersRepository
) : ViewModelProvider.NewInstanceFactory(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }

}

