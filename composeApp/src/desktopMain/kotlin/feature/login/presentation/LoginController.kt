package feature.login.presentation

import data.api.AuthService
import data.api.LoginRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginController(
    private val authService: AuthService
) {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.ChangeField -> {
                when (event.field) {
                    LoginField.USERNAME -> _state.update { it.copy(username = event.text) }
                    LoginField.PASSWORD -> _state.update { it.copy(password = event.text) }
                }
            }
            is LoginEvent.Connect -> {
                CoroutineScope(Dispatchers.IO).launch {
                    val response = authService.login(LoginRequest(_state.value.username, _state.value.password))
                    if (response != null && response.role == "Secretary") {
                        authService.setToken(response.accessToken)
                        _eventFlow.emit(UiEvent.ConnectionSuccess)
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        object ConnectionSuccess: UiEvent()
    }

}