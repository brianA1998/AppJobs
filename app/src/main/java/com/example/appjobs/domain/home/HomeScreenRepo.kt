package com.example.appjobs.domain.home

import com.example.appjobs.core.Resource
import com.example.appjobs.data.model.Publication

interface HomeScreenRepo {
    suspend fun getLatestPublications(): Resource<List<Publication>>

}