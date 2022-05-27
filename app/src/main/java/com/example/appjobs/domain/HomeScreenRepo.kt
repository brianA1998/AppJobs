package com.example.appjobs.domain

import com.example.appjobs.core.Resource
import com.example.appjobs.data.model.Publication

interface HomeScreenRepo {
    suspend fun getLatestPublications(): Resource<List<Publication>>

}