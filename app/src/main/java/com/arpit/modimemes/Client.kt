package com.arpit.modimemes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client{

    val retrofit = Retrofit.Builder()
    .baseUrl("https://namo-memes.herokuapp.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val  api = retrofit.create(ApiService::class.java)


}