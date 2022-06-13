package com.example.appjobs.domain.home

import com.example.appjobs.core.Result
import com.example.appjobs.data.model.Publication

interface HomeScreenRepo {
    suspend fun getLatestPublications(): Result<List<Publication>>

}