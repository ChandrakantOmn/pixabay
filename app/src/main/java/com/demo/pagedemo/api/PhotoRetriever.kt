package com.demo.pagedemo.api

import com.demo.pagedemo.models.APIResponse
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoRetriever {
    private val service: PhotoAPI

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PhotoAPI::class.java)
    }

    fun getPhotos(callback: Callback<APIResponse>) {
        val call = service.getPhotos()
        call.enqueue(callback)
    }
}