package com.example.exampleinterview.data.entities


data class ListPosts (
    var posts:Array<Post>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListPosts

        return posts.contentEquals(other.posts)
    }

    override fun hashCode(): Int {
        return posts.contentHashCode()
    }
}