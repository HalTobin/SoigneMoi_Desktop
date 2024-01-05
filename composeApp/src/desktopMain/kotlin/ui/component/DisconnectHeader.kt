package ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.Strings

@Composable
fun DisconnectHeader(
    onDisconnect: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .background(Color.DarkGray),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            modifier = Modifier.weight(1f).padding(horizontal = 32.dp),
            text = Strings.APP_NAME.uppercase(),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        TextButton(
            modifier = Modifier.padding(end = 32.dp),
            onClick = onDisconnect) {
            Text(text = Strings.DISCONNECT, color = MaterialTheme.colorScheme.primary)
        }

    }
}