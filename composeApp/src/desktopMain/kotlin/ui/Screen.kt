package ui

sealed class Screen(val route: String) {
    object Login: Screen("login")
    object EntryList: Screen("entry_list")
}