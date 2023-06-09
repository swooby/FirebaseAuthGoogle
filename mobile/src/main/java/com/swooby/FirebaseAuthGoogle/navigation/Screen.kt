package com.swooby.FirebaseAuthGoogle.navigation

import com.swooby.FirebaseAuthGoogle.core.Constants.AUTH_SCREEN
import com.swooby.FirebaseAuthGoogle.core.Constants.PROFILE_SCREEN

sealed class Screen(val route: String) {
    object AuthScreen: Screen(AUTH_SCREEN)
    object ProfileScreen: Screen(PROFILE_SCREEN)
}