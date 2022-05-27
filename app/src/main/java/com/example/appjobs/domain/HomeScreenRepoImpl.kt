package com.example.appjobs.domain

import com.example.appjobs.core.Resource
import com.example.appjobs.data.model.Publication

class HomeScreenRepoImpl(private val dataSource: HomeScreenDataSource) : HomeScreenRepo {
    override suspend fun getLatestPublications(): Resource<List<Publication>> {
        TODO("Not yet implemented")
    }

}