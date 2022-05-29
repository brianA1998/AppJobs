package com.example.appjobs.data.model

import com.google.firebase.Timestamp

data class Publication(
    val profile_picture: String = "",
    val profile_name: String = "",
    val post_timestamp: Timestamp? = null,
    val publication_image: String = "",
)
