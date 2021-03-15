package com.example.usermvvm.data.db.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Entity(tableName = "user_table")
class User  (


    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "avatar") var avatar: String,
    @ColumnInfo(name = "birthDate")val birthDate: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "company") val company: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "jobPosition") val jobPosition: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "mobile") val mobile: String,
    @ColumnInfo(name = "role") val role: String,
    @ColumnInfo(name = "username") val username: String
)