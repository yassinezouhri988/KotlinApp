package com.example.usermvvm.data.network.api

import com.example.usermvvm.data.network.NetworkConnectionInterceptor
import com.example.usermvvm.data.network.models.UserResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {

    @GET("AllUsers1")
    suspend fun getUsers() : Response<UserResponse>





    companion object{
        operator fun invoke(
                networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : UserApi {

            val okkHttpclient = OkHttpClient.Builder()
                    .addInterceptor(networkConnectionInterceptor)
                    .build()

            return Retrofit.Builder()
                    .client(okkHttpclient)
                    .baseUrl("http://192.168.255.38:9090/api/users/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(UserApi::class.java)
        }
    }



}