/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.swooby.FirebaseAuthGoogle.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.swooby.FirebaseAuthGoogle.MyViewModel
import com.swooby.FirebaseAuthGoogle.R
import com.swooby.FirebaseAuthGoogle.navigation.NavGraph
import com.swooby.FirebaseAuthGoogle.navigation.Screen.ProfileScreen
import com.swooby.FirebaseAuthGoogle.presentation.auth.AuthViewModel
import com.swooby.FirebaseAuthGoogle.presentation.theme.FirebaseAuthGoogleTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberSwipeDismissableNavController()
            //WearApp("Android")
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

@Composable
fun WearApp(greetingName: String) {
    FirebaseAuthGoogleTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            TimeText()
            Greeting(greetingName = greetingName)
        }
    }
}

@Composable
fun Greeting(greetingName: String) {
    val viewModel: MyViewModel = viewModel()
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                viewModel.text.value = if (viewModel.text.value == "Hello") "Goodbye" else "Hello"
            },
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(R.string.hello_world, viewModel.text.value, greetingName)
    )
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("Preview Android")
}
