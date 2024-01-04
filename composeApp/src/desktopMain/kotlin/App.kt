import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import data.api.auth.AuthService
import feature.login.presentation.LoginScreen
import feature.login.presentation.LoginController
import ui.Screen
import ui.theme.SoigneMoiTheme
import ui.util.NavigationHost
import ui.util.composable
import ui.util.rememberNavController
import util.ConstUrl

@Composable
fun App() {

    val authService = AuthService(ConstUrl.BASE_URL)

    SoigneMoiTheme {
        /*var showContent by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource("compose-multiplatform.xml"), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
        val navController by rememberNavController(Screen.Login.route)

        NavigationHost(navController) {
            composable(Screen.Login.route) {
                val controller = remember { LoginController(authService) }
                val state by controller.state.collectAsState()
                LoginScreen(
                    navController = navController,
                    state = state,
                    onEvent = controller::onEvent,
                    uiEvent = controller.eventFlow
                )
            }
            composable(Screen.EntryList.route) {

            }
        }.build()

    }
}