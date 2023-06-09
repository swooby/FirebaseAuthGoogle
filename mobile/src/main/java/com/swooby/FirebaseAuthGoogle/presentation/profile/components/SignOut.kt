package com.swooby.FirebaseAuthGoogle.presentation.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.swooby.FirebaseAuthGoogle.components.ProgressBar
import com.swooby.FirebaseAuthGoogle.core.Utils.Companion.print
import com.swooby.FirebaseAuthGoogle.domain.model.Response.Failure
import com.swooby.FirebaseAuthGoogle.domain.model.Response.Loading
import com.swooby.FirebaseAuthGoogle.domain.model.Response.Success
import com.swooby.FirebaseAuthGoogle.presentation.profile.ProfileViewModel

@Composable
fun SignOut(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: (signedOut: Boolean) -> Unit
) {
    when (val signOutResponse = viewModel.signOutResponse) {
        is Loading -> ProgressBar()
        is Success -> signOutResponse.data?.let { signedOut ->
            LaunchedEffect(signedOut) {
                navigateToAuthScreen(signedOut)
            }
        }

        is Failure -> LaunchedEffect(Unit) {
            print(signOutResponse.e)
        }
    }
}