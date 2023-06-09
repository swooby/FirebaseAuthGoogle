package com.swooby.FirebaseAuthGoogle.presentation.profile

import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.material.SnackbarResult.ActionPerformed
//import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.Scaffold
import com.swooby.FirebaseAuthGoogle.presentation.profile.components.ProfileContent
import com.swooby.FirebaseAuthGoogle.presentation.profile.components.SignOut

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: () -> Unit
) {
    //val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        /*
        topBar = {
            ProfileTopBar(
                signOut = {
                    viewModel.signOut()
                },
                revokeAccess = {
                    viewModel.revokeAccess()
                }
            )
        },
        */
        content = { //padding ->
            ProfileContent(
                padding = PaddingValues(0.dp),// padding,
                photoUrl = viewModel.photoUrl,
                displayName = viewModel.displayName
            )
        },
        //scaffoldState = scaffoldState
    )

    SignOut(
        navigateToAuthScreen = { signedOut ->
            if (signedOut) {
                navigateToAuthScreen()
            }
        }
    )

    /*
    fun showSnackBar() = coroutineScope.launch {
        val result = scaffoldState.snackbarHostState.showSnackbar(
            message = REVOKE_ACCESS_MESSAGE,
            actionLabel = SIGN_OUT
        )
        if (result == ActionPerformed) {
            viewModel.signOut()
        }
    }

    RevokeAccess(
        navigateToAuthScreen = { accessRevoked ->
            if (accessRevoked) {
                navigateToAuthScreen()
            }
        },
        showSnackBar = {
            showSnackBar()
        }
    )
    */
}