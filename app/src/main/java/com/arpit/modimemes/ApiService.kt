package com.arpit.modimemes

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("memes/:n")
    fun fetchAllMemes(): Call<List<MemeResponse>>
}