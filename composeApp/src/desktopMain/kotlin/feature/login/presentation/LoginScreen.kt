package feature.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.soignemoi.ui.theme.DarkRed
import com.example.soignemoi.ui.theme.LightRed
import data.Strings
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import ui.Screen
import ui.util.NavController

@Composable
fun LoginScreen(
    navController: NavController,
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
    uiEvent: SharedFlow<LoginController.UiEvent>
) {

    LaunchedEffect(key1 = true) {
        uiEvent.collectLatest { event ->
            when (event) {
                is LoginController.UiEvent.ConnectionSuccess -> navController.navigate(Screen.EntryList.route)
            }
        }
    }

    Scaffold {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = Strings.APP_NAME,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = Strings.STAFF_APP,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(0.75f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = Strings.USERNAME) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Characters
                    ),
                    value = state.username,
                    onValueChange = { onEvent(LoginEvent.ChangeField(LoginField.USERNAME, it)) }
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = Strings.PASSWORD) },
                    singleLine = true,
                    visualTransformation =  if (state.showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password
                    ),
                    value = state.password,
                    onValueChange = { onEvent(LoginEvent.ChangeField(LoginField.PASSWORD, it)) }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = state.saveLogin,
                        onCheckedChange = { onEvent(LoginEvent.ChangeSavedLogin(it)) }
                    )
                    Text(modifier = Modifier.padding(start = 16.dp),
                        text = Strings.REMEMBER_LOGIN)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    onClick = { onEvent(LoginEvent.Connect) }) {
                    Text(text = Strings.CONNECTION.uppercase())
                }
            }
            if (state.error) Box(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(2.dp, DarkRed, RoundedCornerShape(8.dp))
                .background(LightRed),
                contentAlignment = Alignment.Center
            ) {
                Text(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                    text = Strings.ERROR_OCCURRED)
            }
        }
    }

}