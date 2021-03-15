package com.example.usermvvm.data.db.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParcelableUser(val id: Int,
                          var avatar: String,
                          val birthDate: String,
                          val city: String,
                          val company: String,
                          val country: String,
                          val email: String,
                          val firstName: String,
                          val jobPosition: String,
                          val lastName: String,
                          val mobile: String,
                          val role: String,
                          val username: String) : Parcelable  {
}