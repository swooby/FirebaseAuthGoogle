package com.swooby.FirebaseAuthGoogle

import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore

class MyApp : Application() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate() {
        super.onCreate()
        db = FirebaseFirestore.getInstance()
    }
}
