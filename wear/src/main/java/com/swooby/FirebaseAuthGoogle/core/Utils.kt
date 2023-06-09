package com.swooby.FirebaseAuthGoogle.core

import android.util.Log
import com.swooby.FirebaseAuthGoogle.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception) = Log.e(TAG, e.stackTraceToString())
    }
}