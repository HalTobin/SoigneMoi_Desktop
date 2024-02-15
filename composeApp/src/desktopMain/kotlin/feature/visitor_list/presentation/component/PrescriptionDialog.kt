package feature.visitor_list.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.soignemoi.feature.prescription.presentation.component.PrescriptionEntryItem
import data.Strings
import data.model.Prescription
import util.DateUtil.formattedDate

@Composable
fun PrescriptionDialog(
    prescription: Prescription,
    onDismiss: () -> Unit
) = Dialog(
    onDismissRequest = onDismiss
) {

    Surface(shape = RoundedCornerShape(8.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.85f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                modifier = Modifier.align(Alignment.End).padding(top = 4.dp, end = 4.dp),
                onClick = onDismiss
            ) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = "${Strings.PRESCRIPTION_ID}${prescription.id}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "${prescription.start.formattedDate} - ${prescription.end.formattedDate}"
            )
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(prescription.entries) {entry ->
                    PrescriptionEntryItem(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                        entry = entry
                    )
                }
            }
        }
    }

}