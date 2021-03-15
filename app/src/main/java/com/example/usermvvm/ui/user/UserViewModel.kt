package com.example.usermvvm.ui.user

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.usermvvm.data.repositories.UsersRepository
import com.example.usermvvm.util.lazyDeferred

@RequiresApi(Build.VERSION_CODES.O)
class UserViewModel(private val repository: UsersRepository ) : ViewModel() {


    val users by lazyDeferred {
        repository.getUsers()
    }

}