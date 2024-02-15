import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import data.api.AuthService
import data.api.PatientService
import feature.login.presentation.LoginScreen
import feature.login.presentation.LoginController
import feature.visitor_list.presentation.VisitorListController
import feature.visitor_list.presentation.VisitorListScreen
import ui.Screen
import ui.theme.SoigneMoiTheme
import ui.util.NavigationHost
import ui.util.composable
import ui.util.rememberNavController
import util.ConstUrl

@Composable
fun App() {

    val authService = AuthService()

    SoigneMoiTheme {
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
                val controller = remember {
                    VisitorListController(PatientService(authService.token ?: ""))
                }
                val state by controller.state.collectAsState()
                VisitorListScreen(
                    navController = navController,
                    state = state,
                    onEvent = controller::onEvent
                )
            }
        }.build()

    }
}