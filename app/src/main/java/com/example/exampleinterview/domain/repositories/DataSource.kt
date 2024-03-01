package com.example.exampleinterview.domain.repositories

import com.example.exampleinterview.data.entities.Post
import com.example.exampleinterview.domain.endpoints.EndPoints
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(EndPoints.GET_POSTS_BY_ID)
    suspend fun getPost(@Path("id") postId: Int): Post

    @GET(EndPoints.GET_ALL_POSTS)
    suspend fun getAllPost(): Array<Post>
}

