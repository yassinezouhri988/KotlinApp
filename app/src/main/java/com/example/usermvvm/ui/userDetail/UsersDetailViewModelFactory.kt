package com.example.usermvvm.ui.userDetail

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usermvvm.data.repositories.UsersRepository
import com.example.usermvvm.ui.userDetail.UserDetailViewModel



@Suppress("UNCHECKED_CAST")
class UsersDetailViewModelFactory (
    private val repository: UsersRepository
) : ViewModelProvider.NewInstanceFactory(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserDetailViewModel(repository) as T
    }

}