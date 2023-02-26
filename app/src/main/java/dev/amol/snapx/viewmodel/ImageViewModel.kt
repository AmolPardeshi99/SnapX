package dev.amol.snapx.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor():ViewModel() {

    private val storage = FirebaseStorage.getInstance()


    fun uploadFile(fileUri: Uri) {
        // Create a reference to the file you want to upload
        val storageRef = storage.reference.child("uploads/${fileUri.lastPathSegment}")

        // Upload the file to Firebase Storage
        val uploadTask = storageRef.putFile(fileUri)

        // Register observers to listen for when the upload is complete or if it fails
        uploadTask.addOnSuccessListener {
            // Handle successful upload

        }.addOnFailureListener {
            // Handle upload failure
        }
    }

}