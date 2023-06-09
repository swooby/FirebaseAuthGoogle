package com.swooby.FirebaseAuthGoogle.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.swooby.FirebaseAuthGoogle.navigation.Screen.AuthScreen
import com.swooby.FirebaseAuthGoogle.navigation.Screen.ProfileScreen
import com.swooby.FirebaseAuthGoogle.presentation.auth.AuthScreen
import com.swooby.FirebaseAuthGoogle.presentation.profile.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = AuthScreen.route,
//        enterTransition = {EnterTransition.None },
//        exitTransition = { ExitTransition.None }
    ) {
        composable(
            route = AuthScreen.route
        ) {
            AuthScreen(
                navigateToProfileScreen = {
                    navController.navigate(ProfileScreen.route)
                }
            )
        }
        composable(
            route = ProfileScreen.route
        ) {
            ProfileScreen(
                navigateToAuthScreen = {
                    navController.popBackStack()
                    navController.navigate(AuthScreen.route)
                }
            )
        }
    }
}
