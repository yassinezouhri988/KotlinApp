package com.example.usermvvm.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    val imageUrl = url.replace("localhost", "192.168.255.38")
    Glide.with(view)
        .load(imageUrl)
        .into(view)
}