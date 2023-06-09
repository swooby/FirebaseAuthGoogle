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
fun RevokeAccess(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: (accessRevoked: Boolean) -> Unit,
    showSnackBar: () -> Unit
) {
    when (val revokeAccessResponse = viewModel.revokeAccessResponse) {
        is Loading -> ProgressBar()
        is Success -> revokeAccessResponse.data?.let { accessRevoked ->
            LaunchedEffect(accessRevoked) {
                navigateToAuthScreen(accessRevoked)
            }
        }

        is Failure -> LaunchedEffect(Unit) {
            print(revokeAccessResponse.e)
            showSnackBar()
        }
    }
}