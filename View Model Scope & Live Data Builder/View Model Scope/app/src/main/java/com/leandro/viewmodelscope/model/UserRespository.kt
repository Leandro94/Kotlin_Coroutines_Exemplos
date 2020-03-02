package com.leandro.viewmodelscope.model

import kotlinx.coroutines.delay

class UserRespository {
    suspend fun getUsers():  List<User>{
        delay(8000)
        val users: List<User> =listOf(
            User(1,"Leandro"),
            User(2,"Marcos"),
            User(3,"Amanda"),
            User(4,"Sarah")

        )
        return users
    }
}