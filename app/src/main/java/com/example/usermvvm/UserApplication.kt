package com.example.usermvvm

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.usermvvm.data.db.UserRoomDatabase
import com.example.usermvvm.data.network.NetworkConnectionInterceptor
import com.example.usermvvm.data.network.api.UserApi
import com.example.usermvvm.util.PreferenceProvider
import com.example.usermvvm.data.repositories.UsersRepository
import com.example.usermvvm.ui.user.UsersViewModelFactory
import com.example.usermvvm.ui.userDetail.UsersDetailViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class UserApplication :  Application(), KodeinAware {

    @RequiresApi(Build.VERSION_CODES.O)
    override val kodein = Kodein.lazy {
        import(androidXModule(this@UserApplication))

        // No need to cancel this scope as it'll be torn down with the process
        //val applicationScope = CoroutineScope(SupervisorJob())

        /*bind() from singleton { UserApi(instance()) }
        bind() from singleton { UserRoomDatabase(instance()) }*/
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { UserApi(instance()) }
        bind() from singleton { UserRoomDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance())}
        bind() from singleton { UsersRepository(instance(), instance(),instance()) }
        bind() from provider { UsersViewModelFactory(instance()) }
        bind() from provider { UsersDetailViewModelFactory(instance()) }




    }

}