package com.example.appjobs.presentation.camera

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.appjobs.core.Result
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class CameraViewModel(private val repo: CameraRepo) : ViewModel() {

    fun uploadPhoto(imageBitmap: Bitmap, description: String) = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {

        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}