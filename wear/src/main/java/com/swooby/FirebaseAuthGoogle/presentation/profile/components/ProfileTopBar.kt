package com.swooby.FirebaseAuthGoogle.presentation.profile.components

import androidx.compose.runtime.Composable

@Composable
fun ProfileTopBar(
    signOut: () -> Unit,
    revokeAccess: () -> Unit
) {
    /*
    var openMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = PROFILE_SCREEN
            )
        },
        actions = {
            IconButton(
                onClick = {
                    openMenu = !openMenu
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = openMenu,
                onDismissRequest = {
                    openMenu = !openMenu
                }
            ) {
                DropdownMenuItem(
                    onClick = {
                        signOut()
                        openMenu = !openMenu
                    }
                ) {
                    Text(
                        text = SIGN_OUT
                    )
                }
                DropdownMenuItem(
                    onClick = {
                        revokeAccess()
                        openMenu = !openMenu
                    }
                ) {
                    Text(
                        text = REVOKE_ACCESS
                    )
                }
            }
        }
    )
    */
}