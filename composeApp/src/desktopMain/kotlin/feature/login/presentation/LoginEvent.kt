package feature.login.presentation

sealed class LoginEvent {
    data class ChangeField(val field: LoginField, val text: String): LoginEvent()
    object Connect: LoginEvent()
}

enum class LoginField { USERNAME, PASSWORD }