package com.swooby.FirebaseAuthGoogle.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.swooby.FirebaseAuthGoogle.navigation.NavGraph
import com.swooby.FirebaseAuthGoogle.navigation.Screen.ProfileScreen
import com.swooby.FirebaseAuthGoogle.presentation.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberAnimatedNavController()
            NavGraph(
                navController = navController
            )
            checkAuthState()
        }
    }

    private fun checkAuthState() {
        if (viewModel.isUserAuthenticated) {
            navigateToProfileScreen()
        }
    }

    private fun navigateToProfileScreen() = navController.navigate(ProfileScreen.route)
}