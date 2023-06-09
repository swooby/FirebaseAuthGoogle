package com.swooby.FirebaseAuthGoogle.presentation.auth.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.swooby.FirebaseAuthGoogle.components.ProgressBar
import com.swooby.FirebaseAuthGoogle.core.Utils.Companion.print
import com.swooby.FirebaseAuthGoogle.domain.model.Response.Failure
import com.swooby.FirebaseAuthGoogle.domain.model.Response.Loading
import com.swooby.FirebaseAuthGoogle.domain.model.Response.Success
import com.swooby.FirebaseAuthGoogle.presentation.auth.AuthViewModel

@Composable
fun SignInWithGoogle(
    viewModel: AuthViewModel = hiltViewModel(),
    navigateToHomeScreen: (signedIn: Boolean) -> Unit
) {
    when (val signInWithGoogleResponse = viewModel.signInWithGoogleResponse) {
        is Loading -> ProgressBar()
        is Success -> signInWithGoogleResponse.data?.let { signedIn ->
            LaunchedEffect(signedIn) {
                navigateToHomeScreen(signedIn)
            }
        }

        is Failure -> LaunchedEffect(Unit) {
            print(signInWithGoogleResponse.e)
        }
    }
}