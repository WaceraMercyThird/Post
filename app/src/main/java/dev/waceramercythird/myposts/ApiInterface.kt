package dev.waceramercythird.myposts

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/post")
    fun getPost(): Call<List<Post>>

}