package com.example.kotlingraphql.resolver

import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller
import java.util.UUID

@Controller
class PostResolver {

    @QueryMapping
    fun getPosts(): List<Post> {
        return listOf(
            Post(
                id = UUID.randomUUID(),
                title = "some title",
                description = "som description"
            ),
            Post(
                id = UUID.randomUUID(),
                title = "second post title",
                description = "second post description"
            )
        )
    }

    // field resolver
    @SchemaMapping(typeName = "Post")
    fun author(post: Post): User {
        return User(
            id = UUID.randomUUID(),
            name = "title=${post.title} id=${post.id}"
        )
    }

    @SchemaMapping(typeName = "User")
    fun posts(user: User): List<Post> {
        return listOf(
            Post(
                id = UUID.randomUUID(),
                title = "test",
                description = "des"
            )
        )
    }
}

data class Post(
    val id: UUID,
    val title: String,
    val description: String
)

data class User(
    val id: UUID,
    val name: String
)