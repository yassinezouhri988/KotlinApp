package com.example.usermvvm.ui.userDetail

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.usermvvm.data.repositories.UsersRepository

@RequiresApi(Build.VERSION_CODES.O)
class UserDetailViewModel(private val repository: UsersRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}