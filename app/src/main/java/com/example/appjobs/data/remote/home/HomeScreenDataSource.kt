package com.example.appjobs.data.remote.home

import android.util.Log
import com.example.appjobs.core.Result
import com.example.appjobs.data.model.Publication
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {

    suspend fun getLatestPublications(): Result<List<Publication>> {
        val publicationList = mutableListOf<Publication>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("posts").get().await()
        for (publication in querySnapshot.documents) {
            publication.toObject(Publication::class.java)?.let { publicationFirebase ->
                publicationList.add(publicationFirebase)
                Log.d("PUBLICATIONS", publicationFirebase.profile_name)
            }

        }
        return Result.Success(publicationList)
    }

}