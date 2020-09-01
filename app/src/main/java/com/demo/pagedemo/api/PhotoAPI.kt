package com.demo.pagedemo.api

import com.demo.pagedemo.models.APIResponse
import retrofit2.Call
import retrofit2.http.GET

interface PhotoAPI {
    @GET("?key=16319352-2bb88398aa817f97a71677f6d&q=cats&image_type=photo")
    fun getPhotos(): Call<APIResponse>
}