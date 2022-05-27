package com.example.appjobs.data.remote

import com.example.appjobs.core.Resource
import com.example.appjobs.data.model.Publication
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {

    suspend fun getLatestPublications(): Resource<List<Publication>> {
        val publicationList = mutableListOf<Publication>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("posts").get().await()
        for (publication in querySnapshot.documents) {
            publication.toObject(Publication::class.java)?.let { publicationFirebase ->
                publicationList.add(publicationFirebase)
            }
        }
        return Resource.Success(publicationList)
    }

}