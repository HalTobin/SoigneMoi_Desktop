import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.Strings
import java.awt.Dimension

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = Strings.APP_NAME, resizable = false) {
        window.minimumSize = Dimension(1280, 720)
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}