package feature.login.presentation

data class LoginState(
    val username: String = "reception1@soignemoi.fr",
    val password: String = "fedir.inna",
    val saveLogin: Boolean = false,
    val showPassword: Boolean = false,
    val error: Boolean = false
)