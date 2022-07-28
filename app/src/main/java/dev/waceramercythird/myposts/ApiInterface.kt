package dev.waceramercythird.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPost(): Call<List<Post>>

    @GET("/post/{id}")
    fun getPostId(@Path("id")postId:Int): Call<Post>

}