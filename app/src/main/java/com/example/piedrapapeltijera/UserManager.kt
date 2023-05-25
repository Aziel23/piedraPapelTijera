package com.example.piedrapapeltijera

object UserManager {
    private val users = mutableMapOf<String, String>()

    fun createUser(username: String, password: String): Boolean {
        return if (users.containsKey(username)) {
            false
        } else {
            users[username] = password
            true
        }
    }

    fun authenticate(username: String, password: String): Boolean {
        return users[username] == password
    }
}
