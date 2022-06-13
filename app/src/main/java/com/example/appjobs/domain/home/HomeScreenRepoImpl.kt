package com.example.appjobs.domain.home

import com.example.appjobs.core.Result
import com.example.appjobs.data.model.Publication
import com.example.appjobs.data.remote.home.HomeScreenDataSource

class HomeScreenRepoImpl(private val dataSource: HomeScreenDataSource) : HomeScreenRepo {
    override suspend fun getLatestPublications(): Result<List<Publication>> {
        return dataSource.getLatestPublications()
    }

}