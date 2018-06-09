package com.example.futux.data

import com.google.gson.annotations.SerializedName

data class User(
        val username: String,
        val name: String,
        @SerializedName("public_repos")
        val publicRepos: Int
)