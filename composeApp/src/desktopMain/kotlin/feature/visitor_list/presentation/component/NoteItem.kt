package feature.visitor_list.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import util.DateUtil.formattedDate
import data.model.Note

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note: Note
) {

    Column {
        Column(modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(4.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = note.title,
                style = MaterialTheme.typography.headlineMedium)
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = note.content,
                style = MaterialTheme.typography.bodyMedium)
            Text(modifier = Modifier.padding(horizontal = 8.dp).fillMaxWidth(),
                text = note.date.formattedDate,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.End)
        }
    }

}