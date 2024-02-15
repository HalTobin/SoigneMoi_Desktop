package feature.visitor_list.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import data.model.Prescription
import util.DateUtil.formattedDate

@Composable
fun PrescriptionItem(
    modifier: Modifier = Modifier,
    prescription: Prescription,
    onSelect: (Prescription) -> Unit
) {

    @Composable
    fun Prescription.getDateString(): String {
        //val days = howManyDays(this.start, this.end)
        return "${this.start.formattedDate} - ${this.end.formattedDate}"
    }

    Column {
        Column(modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onSelect(prescription) }
            .background(MaterialTheme.colorScheme.surface)
            .padding(4.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = prescription.getMedicinesAsString(),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Text(modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
                text = prescription.getDateString(),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.End)
        }
    }

}